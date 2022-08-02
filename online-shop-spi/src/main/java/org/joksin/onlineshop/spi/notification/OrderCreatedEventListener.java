package org.joksin.onlineshop.spi.notification;

import org.joksin.onlineshop.model.event.OrderCreatedEvent;
import org.springframework.context.ApplicationListener;

public interface OrderCreatedEventListener extends ApplicationListener<OrderCreatedEvent> {

}
