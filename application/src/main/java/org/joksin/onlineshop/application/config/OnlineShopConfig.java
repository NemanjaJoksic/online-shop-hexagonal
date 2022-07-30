package org.joksin.onlineshop.application.config;

import org.joksin.onlineshop.core.config.OnlineShopApiConfig;
import org.joksin.onlineshop.rdbms.config.OnlineShopRdbmsRepositoryConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
        OnlineShopApiConfig.class,
        OnlineShopRdbmsRepositoryConfig.class
})
public class OnlineShopConfig {
}
