package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.FindCountriesUseCase;
import org.joksin.onlineshop.model.Country;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class FindCountriesUseCaseImpl implements FindCountriesUseCase {

    @Override
    @Transactional (readOnly = true)
    public Collection<Country> findAll() {
        return List.of(Country.values());
    }

}
