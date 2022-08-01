package org.joksin.onlineshop.rdbms;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.model.Order;
import org.joksin.onlineshop.model.OrderItem;
import org.joksin.onlineshop.rdbms.entity.OrderEntity;
import org.joksin.onlineshop.rdbms.entity.mapper.OrderEntityRowMapper;
import org.joksin.onlineshop.rdbms.mapper.OrderItemMapper;
import org.joksin.onlineshop.rdbms.mapper.OrderMapper;
import org.joksin.onlineshop.rdbms.repository.CustomerCrudRepository;
import org.joksin.onlineshop.rdbms.repository.OrderCrudRepository;
import org.joksin.onlineshop.rdbms.repository.OrderItemCrudRepository;
import org.joksin.onlineshop.spi.persistence.OrderRepository;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.jooq.SelectOnConditionStep;
import org.jooq.impl.DSL;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.jooq.impl.DSL.*;

@Slf4j
@Repository
@AllArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderCrudRepository orderCrudRepository;
    private final OrderItemCrudRepository orderItemCrudRepository;
    private final CustomerCrudRepository customerCrudRepository;

    private final JdbcTemplate jdbcTemplate;
    private final DSLContext dsl;

    private final OrderEntityRowMapper orderEntityRowMapper;

    @Override
    public Collection<Order> findAll() {
        return null;
    }

    @Override
    public Optional<Order> findById(Integer orderId) {

        Query query = buildSelectOrders().where(field("o.id").eq(orderId));

        String sql = query.getSQL();
        List<Object> bindValues = query.getBindValues();

        log.info("SQL: {}", sql);
        log.info("BindValues: {}", bindValues);

        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, orderId);
        OrderEntity orderEntity = orderEntityRowMapper.mapToOrderEntity(sqlRowSet);

        return orderEntity == null ? Optional.empty() : Optional.of(OrderMapper.MAPPER.fromEntity(orderEntity));
    }

    @Override
    public Order create(Order order) {
        OrderEntity createdOrderEntity = orderCrudRepository.save(OrderMapper.MAPPER.toEntity(order));
        orderItemCrudRepository.saveAll(OrderItemMapper.MAPPER.toEntities(createdOrderEntity.getId(), order.getItems()));
        return toOrderWithCustomer(createdOrderEntity, order.getItems());
    }

    private Order toOrderWithCustomer(OrderEntity orderEntity, Collection<OrderItem> orderItems) {
        return customerCrudRepository.findById(orderEntity.getCustomerId())
                .map(customerEntity -> OrderMapper.MAPPER.fromEntity(orderEntity, customerEntity, orderItems))
                .orElseThrow(() -> new RuntimeException("Inconsistent data: Customer with ID " + orderEntity.getCustomerId() + " must exist in the database"));
    }


    private SelectOnConditionStep buildSelectOrders() {
        return dsl.select(
                field("o.id").as("order_id"),
                field("o.created_at").as("order_created_at"),
                field("o.total_price").as("order_total_price"),
                field("o.status_id").as("order_status_id"),
                field("c.id").as("customer_id"),
                field("c.name").as("customer_name"),
                field("c.surname").as("customer_surname"),
                field("c.email").as("customer_email"),
                field("c.country_id").as("customer_country_id"),
                field("oi.id").as("order_item_id"),
                field("oi.quantity").as("order_item_quantity"),
                field("oi.total_price").as("order_item_total_price"),
                field("p.id").as("product_id"),
                field("p.name").as("product_name"),
                field("p.last_updated").as("product_last_updated"),
                field("p.price").as("product_price"),
                field("p.type_id").as("product_type_id"),
                field("m.id").as("manufacturer_id"),
                field("m.name").as("manufacturer_name"),
                field("m.country_id").as("manufacturer_country_id")
        ).from(table("orders").as("o"))
                .join(table("customer").as("c")).on(field("o.customer_id").eq(field("c.id")))
                .join(table("order_item").as("oi")).on(field("o.id").eq(field("oi.order_id")))
                .join(table("product").as("p")).on(field("oi.product_id").eq(field("p.id")))
                .join(table("manufacturer").as("m")).on(field("p.manufacturer_id").eq(field("m.id")));
    }

}
