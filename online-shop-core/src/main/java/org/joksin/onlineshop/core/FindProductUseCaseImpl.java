package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.FindProductUseCase;
import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.spi.persistence.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
public class FindProductUseCaseImpl implements FindProductUseCase {

    private final ProductRepository productRepository;

    @Override
    @Transactional (readOnly = true)
    public Optional<Product> findById(Integer productId) {
        return productRepository.findById(productId);
    }

}
