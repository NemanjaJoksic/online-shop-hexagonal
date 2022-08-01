package org.joksin.onlineshop.restapi.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Builder
public class OrderDTO {

    private Integer id;
    private final LocalDateTime createdAt;
    private final Double totalPrice;
    private final String status;

    private final CustomerDTO customer;
    private final Collection<OrderItemDTO> items;

}
