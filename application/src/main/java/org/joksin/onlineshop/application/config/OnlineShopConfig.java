package org.joksin.onlineshop.application.config;

import org.joksin.onlineshop.core.config.OnlineShopApiConfig;
import org.joksin.onlineshop.email.config.OnlineShopEmailEventListenerConfig;
import org.joksin.onlineshop.rdbms.config.OnlineShopRdbmsRepositoryConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
        OnlineShopApiConfig.class,
        OnlineShopRdbmsRepositoryConfig.class,
        OnlineShopEmailEventListenerConfig.class
})
public class OnlineShopConfig {
}
