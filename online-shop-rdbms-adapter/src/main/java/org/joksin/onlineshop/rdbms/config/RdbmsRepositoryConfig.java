package org.joksin.onlineshop.rdbms.config;

import org.joksin.onlineshop.rdbms.CustomerRepositoryAdapter;
import org.joksin.onlineshop.rdbms.ManufacturerRepositoryAdapter;
import org.joksin.onlineshop.rdbms.ProductRepositoryAdapter;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Import(value = {
        CustomerRepositoryAdapter.class,
        ProductRepositoryAdapter.class,
        ManufacturerRepositoryAdapter.class
})
@EnableJdbcRepositories(basePackages = "org.joksin.onlineshop.rdbms")
public class RdbmsRepositoryConfig {
}
