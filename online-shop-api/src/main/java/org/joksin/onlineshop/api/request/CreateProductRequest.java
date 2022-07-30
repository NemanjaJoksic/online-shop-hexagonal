package org.joksin.onlineshop.api.request;

import lombok.Builder;
import lombok.Getter;
import org.joksin.onlineshop.model.ProductType;

@Getter
@Builder
public class CreateProductRequest {

    private String name;
    private ProductType productType;
    private Double price;
    private Integer manufacturerId;

}
