package org.joksin.onlineshop.restapi.mapper;

import org.joksin.onlineshop.model.Country;
import org.joksin.onlineshop.restapi.dto.CountryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.stream.Collectors;

@Mapper
public interface CountryMapper {

    CountryMapper MAPPER = Mappers.getMapper(CountryMapper.class);

    CountryDTO toDTO(Country country);

    default Collection<CountryDTO> toDTOs(Collection<Country> countries) {
        return countries.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
