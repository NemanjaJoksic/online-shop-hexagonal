package org.joksin.onlineshop.rdbms;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.model.Customer;
import org.joksin.onlineshop.spi.persistence.CustomerRepository;

import java.util.Optional;

@AllArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {

    @Override
    public Optional<Customer> findById(Integer customerId) {
        return Optional.empty();
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return Optional.empty();
    }

}
