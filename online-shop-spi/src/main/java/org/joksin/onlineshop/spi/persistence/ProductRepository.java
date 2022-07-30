package org.joksin.onlineshop.spi.persistence;

import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.model.ProductType;

import java.util.Collection;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(Integer productId);

    Collection<Product> findAll();

    Collection<Product> findAllByType(ProductType productType);

    Collection<Product> findAllByManufacturerId(Integer manufacturerId);

    Product create(Product product);

    Product changePrice(Integer productId, double newPrice);

}
