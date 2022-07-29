package org.joksin.onlineshop.restapi.dto;

import lombok.Builder;
import lombok.Getter;
import org.joksin.onlineshop.model.ProductType;

import java.time.LocalDateTime;

@Getter
@Builder
public class ProductDTO {

    private final Integer id;
    private final String name;
    private final ProductType type;
    private final Double price;
    private final LocalDateTime lastUpdated;

    private final ManufacturerDTO manufacturer;

}
