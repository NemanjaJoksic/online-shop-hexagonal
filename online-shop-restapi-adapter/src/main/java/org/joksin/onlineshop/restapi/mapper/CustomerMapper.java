package org.joksin.onlineshop.restapi.mapper;

import org.joksin.onlineshop.model.Customer;
import org.joksin.onlineshop.restapi.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.stream.Collectors;

@Mapper
public interface CustomerMapper {

    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "country", expression = "java(CountryMapper.MAPPER.toDTO(customer.getCountry()))")
    CustomerDTO toDTO(Customer customer);

    default Collection<CustomerDTO> toDTOs(Collection<Customer> customers) {
        return customers.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
