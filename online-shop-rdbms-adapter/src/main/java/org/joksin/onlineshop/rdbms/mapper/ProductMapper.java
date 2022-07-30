package org.joksin.onlineshop.rdbms.mapper;

import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.rdbms.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.stream.Collectors;

@Mapper
public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "type", expression = "java(ProductType.of(productEntity.getTypeId()))")
    Product fromEntity(ProductEntity productEntity);

    @Mapping(target = "typeId", source = "product.type.id")
    @Mapping(target = "manufacturerId", source = "product.manufacturer.id")
    ProductEntity toEntity(Product product);

    default Collection<Product> fromEntities(Collection<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

}
