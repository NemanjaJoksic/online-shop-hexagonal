package org.joksin.onlineshop.api;

import org.joksin.onlineshop.model.Product;

import java.util.Collection;

public interface FindProductsUseCase {

    Collection<Product> findAll();

    Collection<Product> findAllByManufacturerId(Integer manufacturerId);

}
