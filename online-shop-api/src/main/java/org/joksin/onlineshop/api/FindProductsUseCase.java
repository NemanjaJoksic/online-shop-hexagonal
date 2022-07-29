package org.joksin.onlineshop.api;

import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.model.ProductType;

import java.util.Collection;

public interface FindProductsUseCase {

    Collection<Product> findAll();

    Collection<Product> findAllByType(ProductType productType);

    Collection<Product> findAllByManufacturerId(Integer manufacturerId);

}
