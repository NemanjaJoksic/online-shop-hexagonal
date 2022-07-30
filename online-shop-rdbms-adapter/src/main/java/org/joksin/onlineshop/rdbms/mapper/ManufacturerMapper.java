package org.joksin.onlineshop.rdbms.mapper;

import org.joksin.onlineshop.model.Manufacturer;
import org.joksin.onlineshop.rdbms.entity.ManufacturerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.stream.Collectors;

@Mapper
public interface ManufacturerMapper {

    ManufacturerMapper MAPPER = Mappers.getMapper(ManufacturerMapper.class);

    @Mapping(target = "country", expression = "java(Country.of(manufacturerEntity.getCountryId()))")
    Manufacturer fromEntity(ManufacturerEntity manufacturerEntity);

    @Mapping(target = "countryId", source = "manufacturer.country.id")
    ManufacturerEntity toEntity(Manufacturer manufacturer);

    default Collection<Manufacturer> fromEntities(Collection<ManufacturerEntity> manufacturerEntities) {
        return manufacturerEntities.stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

}
