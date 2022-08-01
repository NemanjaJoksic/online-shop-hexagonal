package org.joksin.onlineshop.spi.persistence;

import org.joksin.onlineshop.model.Order;

public interface OrderRepository {

    Order create(Order order);

}
