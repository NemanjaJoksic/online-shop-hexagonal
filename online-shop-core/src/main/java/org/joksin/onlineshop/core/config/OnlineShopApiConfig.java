package org.joksin.onlineshop.core.config;

import org.joksin.onlineshop.core.ChangeProductPriceUseCaseImpl;
import org.joksin.onlineshop.core.CreateProductUseCaseImpl;
import org.joksin.onlineshop.core.FindProductUseCaseImpl;
import org.joksin.onlineshop.core.FindProductsUseCaseImpl;
import org.springframework.context.annotation.Import;

@Import(value = {
        FindProductUseCaseImpl.class,
        FindProductsUseCaseImpl.class,
        ChangeProductPriceUseCaseImpl.class,
        CreateProductUseCaseImpl.class
})
public class OnlineShopApiConfig {
}
