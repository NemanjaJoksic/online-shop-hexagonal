package org.joksin.onlineshop.restapi.mapper;

import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.restapi.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.stream.Collectors;

@Mapper
public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDTO(Product product);

    default Collection<ProductDTO> toDTOs(Collection<Product> products) {
        return products.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
