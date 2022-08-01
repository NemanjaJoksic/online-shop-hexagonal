package org.joksin.onlineshop.rdbms.mapper;

import org.joksin.onlineshop.model.Order;
import org.joksin.onlineshop.model.OrderItem;
import org.joksin.onlineshop.rdbms.entity.CustomerEntity;
import org.joksin.onlineshop.rdbms.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper
public interface OrderMapper {

    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "statusId", source = "order.status.id")
    @Mapping(target = "customerId", source = "order.customer.id")
    OrderEntity toEntity(Order order);

    @Mapping(target = "id", source = "orderEntity.id")
    @Mapping(target = "status", expression = "java(OrderStatus.of(orderEntity.getStatusId()))")
    @Mapping(target = "customer", expression = "java(CustomerMapper.MAPPER.fromEntity(customerEntity))")
    @Mapping(target = "items", source = "orderItems")
    Order fromEntity(OrderEntity orderEntity, CustomerEntity customerEntity, Collection<OrderItem> orderItems);

}
