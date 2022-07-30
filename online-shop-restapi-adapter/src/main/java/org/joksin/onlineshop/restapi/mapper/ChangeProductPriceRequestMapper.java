package org.joksin.onlineshop.restapi.mapper;

import org.joksin.onlineshop.api.request.ChangeProductPriceRequest;
import org.joksin.onlineshop.restapi.dto.ChangeProductPriceRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChangeProductPriceRequestMapper {

    ChangeProductPriceRequestMapper MAPPER = Mappers.getMapper(ChangeProductPriceRequestMapper.class);

    ChangeProductPriceRequest fromDTO(ChangeProductPriceRequestDTO changeProductPriceRequestDto);

}
