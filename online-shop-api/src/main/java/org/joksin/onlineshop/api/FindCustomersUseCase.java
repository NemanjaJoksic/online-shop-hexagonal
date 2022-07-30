package org.joksin.onlineshop.api;

import org.joksin.onlineshop.model.Customer;

import java.util.Collection;

public interface FindCustomersUseCase {

    Collection<Customer> findAll();

}
