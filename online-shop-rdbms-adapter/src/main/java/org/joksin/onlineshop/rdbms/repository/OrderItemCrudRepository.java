package org.joksin.onlineshop.rdbms.repository;

import org.joksin.onlineshop.rdbms.entity.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemCrudRepository extends CrudRepository<OrderItemEntity, Integer> {
}
