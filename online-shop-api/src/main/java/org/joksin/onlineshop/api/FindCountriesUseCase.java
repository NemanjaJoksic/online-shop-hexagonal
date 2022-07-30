package org.joksin.onlineshop.api;

import org.joksin.onlineshop.model.Country;

import java.util.Collection;

public interface FindCountriesUseCase {

    Collection<Country> findAll();

}
