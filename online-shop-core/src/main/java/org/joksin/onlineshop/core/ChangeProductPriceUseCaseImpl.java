package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.api.ChangeProductPriceUseCase;
import org.joksin.onlineshop.api.request.ChangeProductPriceRequest;
import org.joksin.onlineshop.core.validator.ProductValidator;
import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.spi.persistence.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@AllArgsConstructor
public class ChangeProductPriceUseCaseImpl implements ChangeProductPriceUseCase {

    private final ProductRepository productRepository;
    private final ProductValidator productValidator;

    @Override
    @Transactional
    public Product changePrice(ChangeProductPriceRequest changeProductPriceRequest) {
        productValidator.validateProductExists(changeProductPriceRequest.getProductId());
        return productRepository.changePrice(changeProductPriceRequest.getProductId(), changeProductPriceRequest.getNewPrice());
    }

}
