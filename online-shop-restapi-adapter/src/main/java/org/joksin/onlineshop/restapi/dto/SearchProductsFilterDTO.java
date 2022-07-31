package org.joksin.onlineshop.restapi.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class SearchProductsFilterDTO {

    private final String productName;
    private final List<Integer> productTypeIds;
    private final Double priceFrom;
    private final Double priceTo;
    private final List<Integer> manufacturerIds;

}
