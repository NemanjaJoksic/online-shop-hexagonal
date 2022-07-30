package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.api.FindCountriesUseCase;
import org.joksin.onlineshop.model.Country;

import java.util.Collection;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class FindCountriesUseCaseImpl implements FindCountriesUseCase {

    @Override
    public Collection<Country> findAll() {
        return List.of(Country.values());
    }

}
