package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.FindManufacturersUseCase;
import org.joksin.onlineshop.model.Manufacturer;
import org.joksin.onlineshop.spi.persistence.ManufacturerRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@AllArgsConstructor
public class FindManufacturersUseCaseImpl implements FindManufacturersUseCase {

    private final ManufacturerRepository manufacturerRepository;

    @Override
    @Transactional (readOnly = true)
    public Collection<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

}
