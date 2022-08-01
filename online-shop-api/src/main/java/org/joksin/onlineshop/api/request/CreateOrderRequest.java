package org.joksin.onlineshop.api.request;

import lombok.Builder;
import lombok.Getter;

import java.util.Collection;

@Getter
@Builder
public class CreateOrderRequest {

    private final Integer customerId;
    private final Collection<OrderItemRequest> orderItemRequests;

    @Getter
    @Builder
    public static class OrderItemRequest {
        private final Integer productId;
        private final Integer quantity;
    }

}
