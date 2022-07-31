package org.joksin.onlineshop.api;

import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.model.filter.SearchProductsFilter;

import java.util.Collection;

public interface FindProductsUseCase {

    Collection<Product> findAll(SearchProductsFilter searchProductsFilter);

    Collection<Product> findAllByManufacturerId(Integer manufacturerId);

}
