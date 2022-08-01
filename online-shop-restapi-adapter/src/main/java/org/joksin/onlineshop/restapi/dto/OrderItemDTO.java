package org.joksin.onlineshop.restapi.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderItemDTO {

    private final String id;
    private final Integer quantity;
    private final Double totalPrice;

    private final ProductDTO product;

}
