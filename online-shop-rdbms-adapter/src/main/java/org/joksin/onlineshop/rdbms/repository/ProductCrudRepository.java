package org.joksin.onlineshop.rdbms.repository;

import org.joksin.onlineshop.rdbms.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {

    Boolean existsByNameAndManufacturerId(String name, Integer manufacturerId);

}
