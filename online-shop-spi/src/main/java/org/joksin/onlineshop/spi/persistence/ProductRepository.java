package org.joksin.onlineshop.spi.persistence;

import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.model.filter.SearchProductsFilter;

import java.util.Collection;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(Integer productId);

    Collection<Product> findAll(SearchProductsFilter searchProductsFilter);

    Collection<Product> findAllByManufacturerId(Integer manufacturerId);

    Boolean existsById(Integer productId);

    Boolean existsByNameAndManufacturerId(String productName, Integer manufacturerId);

    Product create(Product product);

    Product changePrice(Integer productId, double newPrice);

}
