package org.joksin.onlineshop.rdbms.repository;

import org.joksin.onlineshop.rdbms.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerCrudRepository extends CrudRepository<CustomerEntity, Integer> {

    Optional<CustomerEntity> findByEmail(String email);

}
