package org.joksin.onlineshop.restapi.mapper;

import org.joksin.onlineshop.model.Order;
import org.joksin.onlineshop.restapi.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.stream.Collectors;

@Mapper
public interface OrderMapper {

    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);

    OrderDTO toDTO(Order order);

    default Collection<OrderDTO> toDTOs(Collection<Order> orders) {
        return orders.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
