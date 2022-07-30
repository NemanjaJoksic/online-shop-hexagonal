package org.joksin.onlineshop.rdbms;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.model.ProductType;
import org.joksin.onlineshop.rdbms.entity.ManufacturerEntity;
import org.joksin.onlineshop.rdbms.entity.ProductEntity;
import org.joksin.onlineshop.rdbms.mapper.ProductMapper;
import org.joksin.onlineshop.rdbms.repository.ManufacturerCrudRepository;
import org.joksin.onlineshop.rdbms.repository.ProductCrudRepository;
import org.joksin.onlineshop.spi.persistence.ProductRepository;
import org.springframework.data.util.Streamable;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductCrudRepository productCrudRepository;
    private final ManufacturerCrudRepository manufacturerCrudRepository;

    @Override
    public Optional<Product> findById(Integer productId) {
        return productCrudRepository.findById(productId)
                .map(this::mapWithManufacturer);
    }

    @Override
    public Collection<Product> findAll() {
        Collection<ProductEntity> productEntities = Streamable.of(productCrudRepository.findAll()).toList();
        return mapWithManufacturer(productEntities);
    }

    @Override
    public Collection<Product> findAllByType(ProductType productType) {
        Collection<ProductEntity> productEntities = Streamable.of(productCrudRepository.findAll()).toList();
        return mapWithManufacturer(productEntities);
    }

    @Override
    public Collection<Product> findAllByManufacturerId(Integer manufacturerId) {
        Collection<ProductEntity> productEntities = Streamable.of(productCrudRepository.findAll()).toList();
        return mapWithManufacturer(productEntities);
    }

    @Override
    public Boolean existsById(Integer productId) {
        return productCrudRepository.existsById(productId);
    }

    @Override
    public Boolean existsByNameAndManufacturerId(String productName, Integer manufacturerId) {
        return productCrudRepository.existsByNameAndManufacturerId(productName, manufacturerId);
    }

    @Override
    public Product create(Product product) {
        ProductEntity createdProductEntity = productCrudRepository.save(ProductMapper.MAPPER.toEntity(product));
        return mapWithManufacturer(createdProductEntity);
    }

    @Override
    public Product changePrice(Integer productId, double newPrice) {
        Integer rowsUpdated = productCrudRepository.updatePriceById(newPrice, productId);
        if (rowsUpdated != 1) {
            throw new RuntimeException("Unexpected number of row(s) updated. Expected to have 1 row updated, but was " + rowsUpdated);
        }

        Optional<Product> updatedProductOptional = findById(productId);
        if (updatedProductOptional.isPresent()) {
            return updatedProductOptional.get();
        } else {
            throw new RuntimeException("Inconsistent data: product with ID " + productId + " must exist in the database");
        }
    }

    private Collection<Product> mapWithManufacturer(Collection<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(this::mapWithManufacturer)
                .collect(Collectors.toList());
    }

    private Product mapWithManufacturer(ProductEntity productEntity) {
        Optional<ManufacturerEntity> manufacturerEntityOptional = manufacturerCrudRepository.findById(productEntity.getManufacturerId());
        if (manufacturerEntityOptional.isPresent()) {
            return ProductMapper.MAPPER.fromEntity(productEntity, manufacturerEntityOptional.get());
        } else {
            throw new RuntimeException("Inconsistent data: manufacturer with ID " + productEntity.getManufacturerId() + " must exist in the database");
        }
    }

}
