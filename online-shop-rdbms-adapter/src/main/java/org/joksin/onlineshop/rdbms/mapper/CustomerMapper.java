package org.joksin.onlineshop.rdbms.mapper;

import org.joksin.onlineshop.model.Customer;
import org.joksin.onlineshop.rdbms.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.stream.Collectors;

@Mapper
public interface CustomerMapper {

    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "country", expression = "java(Country.of(customerEntity.getCountryId()))")
    Customer fromEntity(CustomerEntity customerEntity);

    @Mapping(target = "countryId", source = "customer.country.id")
    CustomerEntity toEntity(Customer customer);

    default Collection<Customer> fromEntities(Collection<CustomerEntity> customerEntities) {
        return customerEntities.stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }
}
