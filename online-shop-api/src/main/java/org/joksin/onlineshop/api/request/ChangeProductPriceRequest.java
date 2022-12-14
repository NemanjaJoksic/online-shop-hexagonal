package org.joksin.onlineshop.api.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChangeProductPriceRequest {

    private final Integer productId;
    private final Double newPrice;

}
