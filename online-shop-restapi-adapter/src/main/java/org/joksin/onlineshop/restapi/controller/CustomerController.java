package org.joksin.onlineshop.restapi.controller;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.FindCustomerUseCase;
import org.joksin.onlineshop.api.FindCustomersUseCase;
import org.joksin.onlineshop.api.FindOrdersUseCase;
import org.joksin.onlineshop.model.Customer;
import org.joksin.onlineshop.model.Order;
import org.joksin.onlineshop.restapi.dto.CustomerDTO;
import org.joksin.onlineshop.restapi.dto.OrderDTO;
import org.joksin.onlineshop.restapi.mapper.CustomerMapper;
import org.joksin.onlineshop.restapi.mapper.OrderMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final FindCustomerUseCase findCustomerUseCase;
    private final FindCustomersUseCase findCustomersUseCase;
    private final FindOrdersUseCase findOrdersUseCase;

    @GetMapping("/api/customers")
    public ResponseEntity<Collection<CustomerDTO>> findAll() {
        Collection<Customer> customers = findCustomersUseCase.findAll();
        if (!customers.isEmpty()) {
            return new ResponseEntity<>(CustomerMapper.MAPPER.toDTOs(customers), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/api/customers/{customerId}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Integer customerId) {
        Optional<Customer> customerOptional = findCustomerUseCase.findById(customerId);
        return customerOptional.map(customer -> new ResponseEntity<>(CustomerMapper.MAPPER.toDTO(customer), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/api/customers/{customerId}/orders")
    public ResponseEntity<Collection<OrderDTO>> findOrdersByCustomerId(@PathVariable Integer customerId) {
        Collection<Order> orders = findOrdersUseCase.findAllByCustomerId(customerId);
        if (!orders.isEmpty()) {
            return new ResponseEntity<>(OrderMapper.MAPPER.toDTOs(orders), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
