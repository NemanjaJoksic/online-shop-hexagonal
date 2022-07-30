package org.joksin.onlineshop.api;

import org.joksin.onlineshop.model.Manufacturer;

import java.util.Optional;

public interface FindManufacturerUseCase {

    Optional<Manufacturer> findById(Integer manufacturerId);

    Optional<Manufacturer> findByName(String manufacturerName);

}
