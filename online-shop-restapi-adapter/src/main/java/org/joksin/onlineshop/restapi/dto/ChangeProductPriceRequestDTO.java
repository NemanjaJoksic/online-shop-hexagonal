package org.joksin.onlineshop.restapi.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChangeProductPriceRequestDTO {

    private final Integer productId;
    private final Double newPrice;

}
