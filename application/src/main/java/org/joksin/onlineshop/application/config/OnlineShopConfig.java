package org.joksin.onlineshop.application.config;

import org.joksin.onlineshop.core.config.OnlineShopApiConfig;
import org.joksin.onlineshop.rdbms.config.RdbmsRepositoryConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
        OnlineShopApiConfig.class,
        RdbmsRepositoryConfig.class
})
public class OnlineShopConfig {
}
