package org.joksin.onlineshop.api;

import org.joksin.onlineshop.model.Order;

import java.util.Optional;

public interface FindOrderUseCase {

    Optional<Order> findById(Integer orderId);

}
