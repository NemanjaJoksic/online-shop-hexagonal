package org.joksin.onlineshop.restapi.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateProductRequestDTO {

    private String name;
    private Integer productTypeId;
    private Double price;
    private Integer manufacturerId;

}
