package org.joksin.onlineshop.model.event;

import org.joksin.onlineshop.model.Order;
import org.springframework.context.ApplicationEvent;

public class OrderCreatedEvent extends ApplicationEvent {

    public OrderCreatedEvent(Order order) {
        super(order);
    }

}
