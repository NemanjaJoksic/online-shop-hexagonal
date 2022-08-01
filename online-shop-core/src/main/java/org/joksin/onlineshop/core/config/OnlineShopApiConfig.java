package org.joksin.onlineshop.core.config;

import org.joksin.onlineshop.core.*;
import org.springframework.context.annotation.Import;

@Import(value = {
        FindProductUseCaseImpl.class,
        FindProductsUseCaseImpl.class,
        ChangeProductPriceUseCaseImpl.class,
        CreateProductUseCaseImpl.class,
        FindCustomerUseCaseImpl.class,
        FindCustomersUseCaseImpl.class,
        FindCountriesUseCaseImpl.class,
        FindManufacturerUseCaseImpl.class,
        FindManufacturersUseCaseImpl.class,
        CreateManufacturerUseCaseImpl.class,
        CreateOrderUseCaseImpl.class,
        FindOrderUseCaseImpl.class
})
public class OnlineShopApiConfig {
}
