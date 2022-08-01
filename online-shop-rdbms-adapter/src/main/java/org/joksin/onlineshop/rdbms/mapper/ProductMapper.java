package org.joksin.onlineshop.rdbms.mapper;

import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.rdbms.entity.ManufacturerEntity;
import org.joksin.onlineshop.rdbms.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "type", expression = "java(ProductType.of(productEntity.getTypeId()))")
    @Mapping(target = "manufacturer", expression = "java(ManufacturerMapper.MAPPER.fromEntity(productEntity.getManufacturer()))")
    Product fromEntity(ProductEntity productEntity);

    @Mapping(target = "id", source = "productEntity.id")
    @Mapping(target = "name", source = "productEntity.name")
    @Mapping(target = "type", expression = "java(ProductType.of(productEntity.getTypeId()))")
    @Mapping(target = "manufacturer", expression = "java(ManufacturerMapper.MAPPER.fromEntity(manufacturerEntity))")
    Product fromEntity(ProductEntity productEntity, ManufacturerEntity manufacturerEntity);

    @Mapping(target = "typeId", source = "product.type.id")
    @Mapping(target = "manufacturerId", source = "product.manufacturer.id")
    ProductEntity toEntity(Product product);

}
