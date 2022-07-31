package org.joksin.onlineshop.model.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.joksin.onlineshop.model.ProductType;

import java.util.Collection;

@Getter
@Builder
@ToString
public class SearchProductsFilter {

    private final String name;
    private final Collection<ProductType> types;
    private final RangeValue<Double> priceRange;
    private final Collection<Integer> manufacturerIds;

}
