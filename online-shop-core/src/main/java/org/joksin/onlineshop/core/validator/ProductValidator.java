package org.joksin.onlineshop.core.validator;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.model.exception.ProductExistsException;
import org.joksin.onlineshop.model.exception.ProductNotExistException;
import org.joksin.onlineshop.spi.persistence.ProductRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductValidator {

    private final ProductRepository productRepository;

    public void validateProductExists(Integer productId) {
        if (!productRepository.existsById(productId)) {
            throw new ProductNotExistException(productId);
        }
    }

    public void validateProductNotExist(String productName, Integer manufacturerId) {
        if (productRepository.existsByNameAndManufacturerId(productName, manufacturerId)) {
            throw new ProductExistsException(productName, manufacturerId);
        }
    }

}
