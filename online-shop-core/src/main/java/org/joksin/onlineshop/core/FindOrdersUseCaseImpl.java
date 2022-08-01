package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.FindOrdersUseCase;
import org.joksin.onlineshop.model.Order;
import org.joksin.onlineshop.spi.persistence.OrderRepository;

import java.util.Collection;

@AllArgsConstructor
public class FindOrdersUseCaseImpl implements FindOrdersUseCase {

    private final OrderRepository orderRepository;

    @Override
    public Collection<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Collection<Order> findAllByCustomerId(Integer customerId) {
        return orderRepository.findAllByCustomerId(customerId);
    }

}
