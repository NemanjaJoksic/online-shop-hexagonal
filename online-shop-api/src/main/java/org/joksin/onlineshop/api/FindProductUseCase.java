package org.joksin.onlineshop.api;

import org.joksin.onlineshop.model.Product;

import java.util.Optional;

public interface FindProductUseCase {

    Optional<Product> findById(Integer productId);

}
