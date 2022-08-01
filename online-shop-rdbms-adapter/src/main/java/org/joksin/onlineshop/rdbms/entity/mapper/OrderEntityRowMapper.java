package org.joksin.onlineshop.rdbms.entity.mapper;

import org.joksin.onlineshop.rdbms.entity.*;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class OrderEntityRowMapper {

    public Collection<OrderEntity> mapToOrderEntities(SqlRowSet sqlRowSet) {
        Map<Integer, OrderEntity> orderEntityMap = new LinkedHashMap<>();

        while (sqlRowSet.next()) {
            Integer orderId = sqlRowSet.getInt("order_id");
            OrderEntity orderEntity = orderEntityMap.get(orderId);

            if (orderEntity == null) {
                orderEntity = fetchOrderEntity(sqlRowSet);
                orderEntityMap.put(orderId, orderEntity);
            }

            orderEntity.getItems().add(fetchOrderItemEntity(sqlRowSet));
        }

        return orderEntityMap.values();
    }

    public OrderEntity mapToOrderEntity(SqlRowSet sqlRowSet) {
        OrderEntity orderEntity = null;

        while (sqlRowSet.next()) {
            if (orderEntity == null) {
                orderEntity = fetchOrderEntity(sqlRowSet);
            }

            orderEntity.getItems().add(fetchOrderItemEntity(sqlRowSet));
        }

        return orderEntity;
    }

    private OrderEntity fetchOrderEntity(SqlRowSet sqlRowSet) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(sqlRowSet.getInt("order_id"));
        orderEntity.setCreatedAt(sqlRowSet.getTimestamp("order_created_at").toLocalDateTime());
        orderEntity.setTotalPrice(sqlRowSet.getDouble("order_total_price"));
        orderEntity.setStatusId(sqlRowSet.getInt("order_status_id"));
        orderEntity.setCustomer(fetchCustomer(sqlRowSet));
        orderEntity.setItems(new ArrayList<>());
        return orderEntity;
    }

    private CustomerEntity fetchCustomer(SqlRowSet sqlRowSet) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(sqlRowSet.getInt("customer_id"));
        customerEntity.setName(sqlRowSet.getString("customer_name"));
        customerEntity.setSurname(sqlRowSet.getString("customer_surname"));
        customerEntity.setEmail(sqlRowSet.getString("customer_email"));
        customerEntity.setCountryId(sqlRowSet.getInt("customer_country_id"));
        return customerEntity;
    }

    private OrderItemEntity fetchOrderItemEntity(SqlRowSet sqlRowSet) {
        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setId(sqlRowSet.getInt("order_item_id"));
        orderItemEntity.setQuantity(sqlRowSet.getInt("order_item_quantity"));
        orderItemEntity.setTotalPrice(sqlRowSet.getDouble("order_item_total_price"));
        orderItemEntity.setProduct(fetchProductEntity(sqlRowSet));
        return orderItemEntity;
    }

    private ProductEntity fetchProductEntity(SqlRowSet sqlRowSet) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(sqlRowSet.getInt("product_id"));
        productEntity.setName(sqlRowSet.getString("product_name"));
        productEntity.setTypeId(sqlRowSet.getInt("product_type_id"));
        productEntity.setPrice(sqlRowSet.getDouble("product_price"));
        productEntity.setLastUpdated(sqlRowSet.getTimestamp("product_last_updated").toLocalDateTime());
        productEntity.setManufacturer(fetchManufacturerEntity(sqlRowSet));
        return productEntity;
    }

    private ManufacturerEntity fetchManufacturerEntity(SqlRowSet sqlRowSet) {
        ManufacturerEntity manufacturerEntity = new ManufacturerEntity();
        manufacturerEntity.setId(sqlRowSet.getInt("manufacturer_id"));
        manufacturerEntity.setName(sqlRowSet.getString("manufacturer_name"));
        manufacturerEntity.setCountryId(sqlRowSet.getInt("manufacturer_country_id"));
        return manufacturerEntity;
    }

}
