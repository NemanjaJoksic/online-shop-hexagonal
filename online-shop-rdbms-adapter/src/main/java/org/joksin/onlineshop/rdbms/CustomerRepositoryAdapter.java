package org.joksin.onlineshop.rdbms;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.model.Customer;
import org.joksin.onlineshop.rdbms.entity.CustomerEntity;
import org.joksin.onlineshop.rdbms.mapper.CustomerMapper;
import org.joksin.onlineshop.rdbms.repository.CustomerCrudRepository;
import org.joksin.onlineshop.spi.persistence.CustomerRepository;
import org.springframework.data.util.Streamable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {

    private final CustomerCrudRepository customerCrudRepository;

    @Override
    public Optional<Customer> findById(Integer customerId) {
        return customerCrudRepository.findById(customerId)
                .map(CustomerMapper.MAPPER::fromEntity);
    }

    @Override
    public Collection<Customer> findAll() {
        List<CustomerEntity> customerEntities = Streamable.of(customerCrudRepository.findAll()).toList();
        return CustomerMapper.MAPPER.fromEntities(customerEntities);
    }

}
