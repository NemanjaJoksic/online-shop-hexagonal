package org.joksin.onlineshop.rdbms.mapper;

import org.joksin.onlineshop.model.OrderItem;
import org.joksin.onlineshop.rdbms.entity.OrderItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.stream.Collectors;

@Mapper
public interface OrderItemMapper {

    OrderItemMapper MAPPER = Mappers.getMapper(OrderItemMapper.class);

    @Mapping(target = "productId", source = "orderItem.product.id")
    @Mapping(target = "orderId", source = "orderId")
    OrderItemEntity toEntity(Integer orderId, OrderItem orderItem);

    @Mapping(target = "orderId", source = "orderId")
    default Collection<OrderItemEntity> toEntities(Integer orderId, Collection<OrderItem> orderItems) {
        return orderItems.stream()
                .map(orderItem -> toEntity(orderId, orderItem))
                .collect(Collectors.toList());
    }

}
