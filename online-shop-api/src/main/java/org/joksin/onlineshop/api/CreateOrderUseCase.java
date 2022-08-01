package org.joksin.onlineshop.api;

import org.joksin.onlineshop.api.request.CreateOrderRequest;
import org.joksin.onlineshop.model.Order;

public interface CreateOrderUseCase {

    Order create(CreateOrderRequest createOrderRequest);

}
