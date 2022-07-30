package org.joksin.onlineshop.api;

import org.joksin.onlineshop.model.Manufacturer;

import java.util.Collection;

public interface FindManufacturersUseCase {

    Collection<Manufacturer> findAll();

}
