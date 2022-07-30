package org.joksin.onlineshop.core;

import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.api.FindProductUseCase;
import org.joksin.onlineshop.model.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
public class FindProductUseCaseImpl implements FindProductUseCase {

    @Override
    @Transactional (readOnly = true)
    public Optional<Product> findById(Integer productId) {
        return Optional.empty();
    }

}
