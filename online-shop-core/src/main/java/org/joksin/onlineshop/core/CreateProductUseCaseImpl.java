package org.joksin.onlineshop.core;

import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.api.CreateProductUseCase;
import org.joksin.onlineshop.api.request.CreateProductRequest;
import org.joksin.onlineshop.model.Product;

@Slf4j
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    @Override
    public Product create(CreateProductRequest createProductRequest) {
        return null;
    }

}
