package org.joksin.onlineshop.restapi.mapper;

import org.joksin.onlineshop.model.filter.SearchProductsFilter;
import org.joksin.onlineshop.restapi.dto.SearchProductsFilterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SearchProductsFilterMapper {

    SearchProductsFilterMapper MAPPER = Mappers.getMapper(SearchProductsFilterMapper.class);

    @Mapping(target = "name", source = "productName")
    @Mapping(target = "types", expression = "java(ProductTypeMapper.MAPPER.fromIds(searchProductsFilterDto.getProductTypeIds()))")
    @Mapping(target = "priceRange.from", source = "searchProductsFilterDto.priceFrom")
    @Mapping(target = "priceRange.to", source = "searchProductsFilterDto.priceTo")
    SearchProductsFilter fromDTO(SearchProductsFilterDTO searchProductsFilterDto);

}
