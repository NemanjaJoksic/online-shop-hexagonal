package org.joksin.onlineshop.restapi.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderItemRequestDTO {

    private final Integer productId;
    private final Integer quantity;

}
