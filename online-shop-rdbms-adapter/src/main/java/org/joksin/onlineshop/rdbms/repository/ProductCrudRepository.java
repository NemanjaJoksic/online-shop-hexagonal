package org.joksin.onlineshop.rdbms.repository;

import org.joksin.onlineshop.rdbms.entity.ProductEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {

    Collection<ProductEntity> findAllByManufacturerId(Integer manufacturerId);

    Boolean existsByNameAndManufacturerId(String name, Integer manufacturerId);

    @Modifying
    @Query(value = "update product set price = :newPrice, last_updated = timezone('utc', now())::timestamp where id = :productId")
    Integer updatePriceById(Double newPrice, Integer productId);

}
