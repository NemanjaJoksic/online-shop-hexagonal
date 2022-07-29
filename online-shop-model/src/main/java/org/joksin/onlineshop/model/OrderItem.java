package org.joksin.onlineshop.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderItem {

    private final String id;
    private final Integer quantity;
    private final Double totalPrice;

    private final Product product;

}
