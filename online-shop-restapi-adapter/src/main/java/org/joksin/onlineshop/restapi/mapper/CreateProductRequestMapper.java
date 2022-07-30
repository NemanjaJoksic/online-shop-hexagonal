package org.joksin.onlineshop.restapi.mapper;

import org.joksin.onlineshop.api.request.CreateProductRequest;
import org.joksin.onlineshop.model.ProductType;
import org.joksin.onlineshop.restapi.dto.CreateProductRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(imports = {
        ProductType.class
})
public interface CreateProductRequestMapper {

    CreateProductRequestMapper MAPPER = Mappers.getMapper(CreateProductRequestMapper.class);

    @Mapping (target = "productType", expression = "java(ProductType.of(createProductRequestDto.getProductTypeId()))")
    CreateProductRequest fromDTO(CreateProductRequestDTO createProductRequestDto);

}
