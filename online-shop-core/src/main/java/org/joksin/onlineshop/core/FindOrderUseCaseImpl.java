package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.FindOrderUseCase;
import org.joksin.onlineshop.model.Order;
import org.joksin.onlineshop.spi.persistence.OrderRepository;

import java.util.Optional;

@AllArgsConstructor
public class FindOrderUseCaseImpl implements FindOrderUseCase {

    private final OrderRepository orderRepository;

    @Override
    public Optional<Order> findById(Integer orderId) {
        return orderRepository.findById(orderId);
    }

}
