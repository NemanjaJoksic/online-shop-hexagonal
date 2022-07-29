package org.joksin.onlineshop.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Product {

    private final Integer id;
    private final String name;
    private final ProductType type;
    private final Double price;
    private final LocalDateTime lastUpdated;

    private final Manufacturer manufacturer;

}
