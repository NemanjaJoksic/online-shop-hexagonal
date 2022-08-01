package org.joksin.onlineshop.rdbms.mapper;

import org.joksin.onlineshop.model.ProductType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.stream.Collectors;

@Mapper
public interface ProductTypeMapper {

    ProductTypeMapper MAPPER = Mappers.getMapper(ProductTypeMapper.class);

    default Collection<Integer> toIds(Collection<ProductType> productTypes) {
        return productTypes.stream()
                .map(ProductType::getId)
                .collect(Collectors.toList());
    }

}
