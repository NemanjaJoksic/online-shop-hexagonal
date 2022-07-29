package org.joksin.onlineshop.restapi.dto;

import lombok.Builder;
import lombok.Getter;
import org.joksin.onlineshop.model.ProductType;

@Getter
@Builder
public class CreateProductRequestDTO {

    private String name;
    private ProductType type;
    private Double price;
    private Integer manufacturerId;

}
