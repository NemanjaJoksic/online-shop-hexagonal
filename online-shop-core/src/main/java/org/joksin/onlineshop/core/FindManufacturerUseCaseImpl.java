package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.FindManufacturerUseCase;
import org.joksin.onlineshop.model.Manufacturer;

import java.util.Optional;

@AllArgsConstructor
public class FindManufacturerUseCaseImpl implements FindManufacturerUseCase {

    @Override
    public Optional<Manufacturer> findById(Integer manufacturerId) {
        return Optional.empty();
    }

    @Override
    public Optional<Manufacturer> findByName(String name) {
        return Optional.empty();
    }

}
