package org.joksin.onlineshop.api.request;

import lombok.Builder;
import lombok.Getter;
import org.joksin.onlineshop.model.ProductType;

@Getter
@Builder
public class CreateProductRequest {

    private final String name;
    private final ProductType productType;
    private final Double price;
    private final Integer manufacturerId;

}
