package org.joksin.onlineshop.rdbms.config;

import org.joksin.onlineshop.rdbms.CustomerRepositoryAdapter;
import org.joksin.onlineshop.rdbms.ProductRepositoryAdapter;
import org.springframework.context.annotation.Import;

@Import(value = {
        CustomerRepositoryAdapter.class,
        ProductRepositoryAdapter.class
})
public class RdbmsRepositoryConfig {
}
