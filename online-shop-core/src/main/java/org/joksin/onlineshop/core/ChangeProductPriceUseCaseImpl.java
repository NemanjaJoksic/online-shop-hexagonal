package org.joksin.onlineshop.core;

import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.api.ChangeProductPriceUseCase;
import org.joksin.onlineshop.api.request.ChangeProductPriceRequest;
import org.joksin.onlineshop.model.Product;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class ChangeProductPriceUseCaseImpl implements ChangeProductPriceUseCase, InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Binding ChangeProductPriceUseCaseImpl to ChangeProductPriceUseCase");
    }

    @Override
    public Product changePrice(ChangeProductPriceRequest changeProductPriceRequest) {
        return null;
    }

}
