package org.joksin.onlineshop.restapi.mapper;

import org.joksin.onlineshop.model.ProductType;
import org.joksin.onlineshop.restapi.dto.ProductTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductTypeMapper {

    ProductTypeMapper MAPPER = Mappers.getMapper(ProductTypeMapper.class);

    ProductTypeDTO toDTO(ProductType productType);

}
