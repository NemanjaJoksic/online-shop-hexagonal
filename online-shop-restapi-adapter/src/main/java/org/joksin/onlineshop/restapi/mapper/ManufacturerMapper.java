package org.joksin.onlineshop.restapi.mapper;

import org.joksin.onlineshop.model.Manufacturer;
import org.joksin.onlineshop.restapi.dto.ManufacturerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.stream.Collectors;

@Mapper
public interface ManufacturerMapper {

    ManufacturerMapper MAPPER = Mappers.getMapper(ManufacturerMapper.class);

    @Mapping (target = "country", expression = "java(CountryMapper.MAPPER.toDTO(manufacturer.getCountry()))")
    ManufacturerDTO toDTO(Manufacturer manufacturer);

    default Collection<ManufacturerDTO> toDTOs(Collection<Manufacturer> manufacturers) {
        return manufacturers.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
