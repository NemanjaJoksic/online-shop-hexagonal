package org.joksin.onlineshop.api;

import org.joksin.onlineshop.api.request.CreateProductRequest;
import org.joksin.onlineshop.model.Product;

public interface CreateProductUseCase {

    Product create(CreateProductRequest createProductRequest);

}
