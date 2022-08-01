package org.joksin.onlineshop.rdbms.repository;

import org.joksin.onlineshop.rdbms.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderCrudRepository extends CrudRepository<OrderEntity, Integer> {
}
