package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.FindManufacturerUseCase;
import org.joksin.onlineshop.model.Manufacturer;
import org.joksin.onlineshop.spi.persistence.ManufacturerRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
public class FindManufacturerUseCaseImpl implements FindManufacturerUseCase {

    private final ManufacturerRepository manufacturerRepository;

    @Override
    @Transactional (readOnly = true)
    public Optional<Manufacturer> findById(Integer manufacturerId) {
        return manufacturerRepository.findById(manufacturerId);
    }

    @Override
    @Transactional (readOnly = true)
    public Optional<Manufacturer> findByName(String manufacturerName) {
        return manufacturerRepository.findByName(manufacturerName);
    }

}
