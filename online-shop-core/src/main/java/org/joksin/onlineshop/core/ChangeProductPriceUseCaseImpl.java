package org.joksin.onlineshop.core;

import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.api.ChangeProductPriceUseCase;
import org.joksin.onlineshop.api.request.ChangeProductPriceRequest;
import org.joksin.onlineshop.model.Product;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
public class ChangeProductPriceUseCaseImpl implements ChangeProductPriceUseCase {

    @Override
    @Transactional
    public Product changePrice(ChangeProductPriceRequest changeProductPriceRequest) {
        return null;
    }

}
