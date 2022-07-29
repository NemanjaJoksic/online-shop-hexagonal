package org.joksin.onlineshop.restapi.mapper;

import org.joksin.onlineshop.api.request.CreateProductRequest;
import org.joksin.onlineshop.restapi.dto.CreateProductRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreateProductRequestMapper {

    CreateProductRequestMapper MAPPER = Mappers.getMapper(CreateProductRequestMapper.class);

    CreateProductRequest fromDTO(CreateProductRequestDTO createProductRequestDto);

}
