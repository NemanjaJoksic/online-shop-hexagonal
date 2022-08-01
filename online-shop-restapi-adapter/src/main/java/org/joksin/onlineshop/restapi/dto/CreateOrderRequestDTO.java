package org.joksin.onlineshop.restapi.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Collection;

@Getter
@Builder
public class CreateOrderRequestDTO {

    private final Integer customerId;
    private final Collection<OrderItemRequestDTO> orderItemRequests;

}
