package org.joksin.onlineshop.rdbms;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.model.Order;
import org.joksin.onlineshop.model.OrderItem;
import org.joksin.onlineshop.rdbms.entity.OrderEntity;
import org.joksin.onlineshop.rdbms.entity.OrderItemEntity;
import org.joksin.onlineshop.rdbms.mapper.OrderItemMapper;
import org.joksin.onlineshop.rdbms.mapper.OrderMapper;
import org.joksin.onlineshop.rdbms.repository.CustomerCrudRepository;
import org.joksin.onlineshop.rdbms.repository.OrderCrudRepository;
import org.joksin.onlineshop.rdbms.repository.OrderItemCrudRepository;
import org.joksin.onlineshop.spi.persistence.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@AllArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderCrudRepository orderCrudRepository;
    private final OrderItemCrudRepository orderItemCrudRepository;
    private final CustomerCrudRepository customerCrudRepository;

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

}
