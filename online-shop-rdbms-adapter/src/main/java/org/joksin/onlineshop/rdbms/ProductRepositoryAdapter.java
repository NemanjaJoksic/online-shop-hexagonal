package org.joksin.onlineshop.rdbms;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.model.ProductType;
import org.joksin.onlineshop.rdbms.entity.ProductEntity;
import org.joksin.onlineshop.rdbms.mapper.ProductMapper;
import org.joksin.onlineshop.rdbms.repository.ProductCrudRepository;
import org.joksin.onlineshop.spi.persistence.ProductRepository;
import org.springframework.data.util.Streamable;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductCrudRepository productCrudRepository;

    @Override
    public Optional<Product> findById(Integer productId) {
        return productCrudRepository.findById(productId)
                .map(ProductMapper.MAPPER::fromEntity);
    }

    @Override
    public Collection<Product> findAll() {
        Collection<ProductEntity> productEntities = Streamable.of(productCrudRepository.findAll()).toList();
        return ProductMapper.MAPPER.fromEntities(productEntities);
    }

    @Override
    public Collection<Product> findAllByType(ProductType productType) {
        Collection<ProductEntity> productEntities = Streamable.of(productCrudRepository.findAll()).toList();
        return ProductMapper.MAPPER.fromEntities(productEntities);
    }

    @Override
    public Collection<Product> findAllByManufacturerId(Integer manufacturerId) {
        Collection<ProductEntity> productEntities = Streamable.of(productCrudRepository.findAll()).toList();
        return ProductMapper.MAPPER.fromEntities(productEntities);
    }

    @Override
    public Boolean existsByNameAndManufacturerId(String productName, Integer manufacturerId) {
        return productCrudRepository.existsByNameAndManufacturerId(productName, manufacturerId);
    }

    @Override
    public Product create(Product product) {
        ProductEntity createdProductEntity = productCrudRepository.save(ProductMapper.MAPPER.toEntity(product));
        return ProductMapper.MAPPER.fromEntity(createdProductEntity);
    }

    @Override
    public Product changePrice(Integer productId, double newPrice) {
        return null;
    }

}
