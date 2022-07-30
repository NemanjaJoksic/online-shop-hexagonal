package org.joksin.onlineshop.core;

import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.api.FindProductsUseCase;
import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.model.ProductType;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;

@Slf4j
public class FindProductsUseCaseImpl implements FindProductsUseCase {

    @Override
    @Transactional(readOnly = true)
    public Collection<Product> findAll() {
        return Collections.emptyList();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Product> findAllByType(ProductType productType) {
        return Collections.emptyList();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Product> findAllByManufacturerId(Integer manufacturerId) {
        return Collections.emptyList();
    }

}
