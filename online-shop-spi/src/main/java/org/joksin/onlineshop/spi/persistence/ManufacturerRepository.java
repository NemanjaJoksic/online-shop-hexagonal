package org.joksin.onlineshop.spi.persistence;

import org.joksin.onlineshop.model.Manufacturer;

import java.util.Collection;
import java.util.Optional;

public interface ManufacturerRepository {

    Collection<Manufacturer> findAll();

    Optional<Manufacturer> findById(Integer manufacturerId);

    Optional<Manufacturer> findByName(String manufacturerName);

    Boolean existsById(Integer manufacturerId);

    Boolean existsByName(String manufacturerName);

    Manufacturer create(Manufacturer manufacturer);

}
