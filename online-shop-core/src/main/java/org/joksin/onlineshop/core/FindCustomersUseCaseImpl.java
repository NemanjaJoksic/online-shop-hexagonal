package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.FindCustomersUseCase;
import org.joksin.onlineshop.model.Customer;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
public class FindCustomersUseCaseImpl implements FindCustomersUseCase {

    @Override
    public Collection<Customer> findAll() {
        return Collections.emptyList();
    }

}
