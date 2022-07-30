package org.joksin.onlineshop.restapi.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ProductDTO {

    private final Integer id;
    private final String name;
    private final ProductTypeDTO type;
    private final Double price;
    private final LocalDateTime lastUpdated;

    private final ManufacturerDTO manufacturer;

}
