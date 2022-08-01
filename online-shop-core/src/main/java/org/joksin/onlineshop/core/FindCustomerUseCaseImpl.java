package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.FindCustomerUseCase;
import org.joksin.onlineshop.model.Customer;
import org.joksin.onlineshop.spi.persistence.CustomerRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
public class FindCustomerUseCaseImpl implements FindCustomerUseCase {

    private final CustomerRepository customerRepository;

    @Override
    @Transactional (readOnly = true)
    public Optional<Customer> findById(Integer customerId) {
        return customerRepository.findById(customerId);
    }

}
