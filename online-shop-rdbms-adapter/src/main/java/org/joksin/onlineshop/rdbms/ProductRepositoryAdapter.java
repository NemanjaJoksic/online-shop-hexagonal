package org.joksin.onlineshop.rdbms;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.model.ProductType;
import org.joksin.onlineshop.spi.persistence.ProductRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    @Override
    public Optional<Product> findById(Integer productId) {
        return Optional.empty();
    }

    @Override
    public Collection<Product> findAll() {
        return null;
    }

    @Override
    public Collection<Product> findAllByType(ProductType productType) {
        return null;
    }

    @Override
    public Collection<Product> findAllByManufacturerId(Integer manufacturerId) {
        return null;
    }

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public Product changePrice(Integer productId, double newPrice) {
        return null;
    }

}
