package org.joksin.onlineshop.spi.persistence;

import org.joksin.onlineshop.model.Order;

import java.util.Collection;
import java.util.Optional;

public interface OrderRepository {

    Collection<Order> findAll();

    Collection<Order> findAllByCustomerId(Integer customerId);

    Optional<Order> findById(Integer orderId);

    Order create(Order order);

}
