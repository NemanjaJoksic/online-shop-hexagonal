package org.joksin.onlineshop.restapi.controller;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.CreateOrderUseCase;
import org.joksin.onlineshop.api.FindOrderUseCase;
import org.joksin.onlineshop.api.FindOrdersUseCase;
import org.joksin.onlineshop.model.Order;
import org.joksin.onlineshop.restapi.dto.CreateOrderRequestDTO;
import org.joksin.onlineshop.restapi.dto.OrderDTO;
import org.joksin.onlineshop.restapi.mapper.CreateOrderRequestMapper;
import org.joksin.onlineshop.restapi.mapper.OrderMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final FindOrderUseCase findOrderUseCase;
    private final FindOrdersUseCase findOrdersUseCase;

    @PostMapping("/api/orders")
    public ResponseEntity<OrderDTO> create(@RequestBody CreateOrderRequestDTO createOrderRequestDto) {
        Order createdOrder = createOrderUseCase.create(CreateOrderRequestMapper.MAPPER.fromDTO(createOrderRequestDto));
        return new ResponseEntity<>(OrderMapper.MAPPER.toDTO(createdOrder), HttpStatus.CREATED);
    }

    @GetMapping("/api/orders")
    public ResponseEntity<Collection<OrderDTO>> findAll() {
        Collection<Order> orders = findOrdersUseCase.findAll();
        if (!orders.isEmpty()) {
            return new ResponseEntity<>(OrderMapper.MAPPER.toDTOs(orders), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/api/orders/{orderId}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Integer orderId) {
        Optional<Order> orderOptional = findOrderUseCase.findById(orderId);
        return orderOptional.map(order -> new ResponseEntity<>(OrderMapper.MAPPER.toDTO(order), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

}
