package org.joksin.onlineshop.core;

import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.api.FindProductUseCase;
import org.joksin.onlineshop.model.Product;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
public class FindProductUseCaseImpl implements FindProductUseCase, InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Binding FindProductUseCaseImpl to FindProductUseCase");
    }

    @Override
    @Transactional (readOnly = true)
    public Optional<Product> findProductById(Integer productId) {
        return Optional.empty();
    }

}
