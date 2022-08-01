package org.joksin.onlineshop.core;

import commons.DateTimeUtil;
import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.CreateOrderUseCase;
import org.joksin.onlineshop.api.request.CreateOrderRequest;
import org.joksin.onlineshop.model.*;
import org.joksin.onlineshop.model.exception.ProductNotExistException;
import org.joksin.onlineshop.spi.persistence.OrderRepository;
import org.joksin.onlineshop.spi.persistence.ProductRepository;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    public Order create(CreateOrderRequest createOrderRequest) {

        double totalPrice = 0;
        List<OrderItem> orderItems = new LinkedList<>();
        for (CreateOrderRequest.OrderItemRequest orderItemRequest : createOrderRequest.getOrderItemRequests()) {

            Integer productId = orderItemRequest.getProductId();
            Integer quantity = orderItemRequest.getQuantity();

            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ProductNotExistException(productId));

            double orderItemTotalPrice = product.getPrice() * quantity;
            totalPrice += orderItemTotalPrice;

            OrderItem orderItem = OrderItem.builder()
                    .quantity(quantity)
                    .totalPrice(orderItemTotalPrice)
                    .product(product)
                    .build();

            orderItems.add(orderItem);
        }

        Order order = Order.builder()
                .status(OrderStatus.PREPARING)
                .createdAt(DateTimeUtil.getNowUTC())
                .totalPrice(totalPrice)
                .customer(Customer.of(createOrderRequest.getCustomerId()))
                .items(orderItems)
                .build();

        return orderRepository.create(order);
    }

}
