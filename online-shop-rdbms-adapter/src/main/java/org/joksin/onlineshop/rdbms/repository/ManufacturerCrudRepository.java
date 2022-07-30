package org.joksin.onlineshop.rdbms.repository;

import org.joksin.onlineshop.rdbms.entity.ManufacturerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ManufacturerCrudRepository extends CrudRepository<ManufacturerEntity, Integer> {

    Optional<ManufacturerEntity> findByName(String name);

    Boolean existsByName(String name);

}
