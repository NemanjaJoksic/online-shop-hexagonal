package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.FindManufacturersUseCase;
import org.joksin.onlineshop.model.Manufacturer;

import java.util.Collection;

@AllArgsConstructor
public class FindManufacturersUseCaseImpl implements FindManufacturersUseCase {

    @Override
    public Collection<Manufacturer> findAll() {
        return null;
    }

}
