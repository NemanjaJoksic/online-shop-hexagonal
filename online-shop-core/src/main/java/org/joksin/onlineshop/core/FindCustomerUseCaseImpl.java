package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.api.FindCustomerUseCase;
import org.joksin.onlineshop.model.Customer;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
public class FindCustomerUseCaseImpl implements FindCustomerUseCase {

    @Override
    public Optional<Customer> findById(Integer customerId) {
        return Optional.empty();
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return Optional.empty();
    }

}
