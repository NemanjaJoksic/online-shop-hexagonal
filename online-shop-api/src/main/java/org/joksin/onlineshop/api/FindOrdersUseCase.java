package org.joksin.onlineshop.api;

import org.joksin.onlineshop.model.Order;

import java.util.Collection;

public interface FindOrdersUseCase {

    Collection<Order> findAll();

    Collection<Order> findAllByCustomerId(Integer customerId);

}
