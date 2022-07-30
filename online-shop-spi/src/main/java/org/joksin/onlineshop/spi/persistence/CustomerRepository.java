package org.joksin.onlineshop.spi.persistence;

import org.joksin.onlineshop.model.Customer;

import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> findById(Integer customerId);

    Optional<Customer> findByEmail(String email);

}
