package org.joksin.onlineshop.restapi.mapper;

import org.joksin.onlineshop.api.request.CreateOrderRequest;
import org.joksin.onlineshop.restapi.dto.CreateOrderRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreateOrderRequestMapper {

    CreateOrderRequestMapper MAPPER = Mappers.getMapper(CreateOrderRequestMapper.class);

    CreateOrderRequest fromDTO(CreateOrderRequestDTO createOrderRequestDto);

}
