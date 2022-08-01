package org.joksin.onlineshop.restapi.mapper;

import org.joksin.onlineshop.model.Order;
import org.joksin.onlineshop.restapi.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);

    OrderDTO toDTO(Order order);

}
