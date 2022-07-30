package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.api.FindProductUseCase;
import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.spi.persistence.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
public class FindProductUseCaseImpl implements FindProductUseCase {

    private final ProductRepository productRepository;

    @Override
    @Transactional (readOnly = true)
    public Optional<Product> findById(Integer productId) {
        return productRepository.findById(productId);
    }

}
