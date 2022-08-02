package org.joksin.onlineshop.email;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.model.Order;
import org.joksin.onlineshop.model.event.OrderCreatedEvent;
import org.joksin.onlineshop.spi.notification.OrderCreatedEventListener;

@Slf4j
public class EmailOrderCreatedEventListener implements OrderCreatedEventListener {

    public EmailOrderCreatedEventListener() {
        log.info("EmailOrderNotificationListener created");
    }

    @Override
    @SneakyThrows(InterruptedException.class)
    public void onApplicationEvent(OrderCreatedEvent orderCreatedEvent) {
        Order order = (Order) orderCreatedEvent.getSource();
        log.info("New OrderCreatedEvent received. Sending email to {} for order with ID {}", order.getCustomer().getEmail(), order.getId());
        Thread.sleep(500); // wait 0.5s
        log.info("Email sent to {} for order with ID {}", order.getCustomer().getEmail(), order.getId());
    }

}
