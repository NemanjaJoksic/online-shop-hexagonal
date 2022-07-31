package org.joksin.onlineshop.api;

import org.joksin.onlineshop.model.Customer;

import java.util.Optional;

public interface FindCustomerUseCase {

    Optional<Customer> findById(Integer customerId);

}
