package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.api.FindProductsUseCase;
import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.spi.persistence.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Slf4j
@AllArgsConstructor
public class FindProductsUseCaseImpl implements FindProductsUseCase {

    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public Collection<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Product> findAllByManufacturerId(Integer manufacturerId) {
        return productRepository.findAllByManufacturerId(manufacturerId);
    }

}
