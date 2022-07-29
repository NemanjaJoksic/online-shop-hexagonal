package org.joksin.onlineshop.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Builder
public class Order {

    private final Integer id;
    private final LocalDateTime createAt;
    private final Double totalPrice;
    private final OrderStatus status;

    private final Customer customer;
    private final Collection<OrderItem> items;

}
