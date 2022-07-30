package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.FindCustomersUseCase;
import org.joksin.onlineshop.model.Customer;
import org.joksin.onlineshop.spi.persistence.CustomerRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@AllArgsConstructor
public class FindCustomersUseCaseImpl implements FindCustomersUseCase {

    private final CustomerRepository customerRepository;

    @Override
    @Transactional (readOnly = true)
    public Collection<Customer> findAll() {
        return customerRepository.findAll();
    }

}
