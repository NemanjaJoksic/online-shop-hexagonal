package org.joksin.onlineshop.restapi.mapper;

import org.joksin.onlineshop.model.ProductType;
import org.joksin.onlineshop.restapi.dto.ProductTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.stream.Collectors;

@Mapper
public interface ProductTypeMapper {

    ProductTypeMapper MAPPER = Mappers.getMapper(ProductTypeMapper.class);

    ProductTypeDTO toDTO(ProductType productType);

    default Collection<ProductType> fromIds(Collection<Integer> productTypeIds) {
        if (!CollectionUtils.isEmpty(productTypeIds)) {
            return productTypeIds.stream()
                    .map(ProductType::of)
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

}
