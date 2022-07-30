package org.joksin.onlineshop.restapi.mapper;

import org.joksin.onlineshop.api.request.CreateManufacturerRequest;
import org.joksin.onlineshop.model.Country;
import org.joksin.onlineshop.restapi.dto.CreateManufacturerRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(imports = {
        Country.class
})
public interface CreateManufacturerRequestMapper {

    CreateManufacturerRequestMapper MAPPER = Mappers.getMapper(CreateManufacturerRequestMapper.class);

    @Mapping(target = "country", expression = "java(Country.of(createManufacturerRequestDto.getCountryId()))")
    CreateManufacturerRequest fromDTO(CreateManufacturerRequestDTO createManufacturerRequestDto);

}
