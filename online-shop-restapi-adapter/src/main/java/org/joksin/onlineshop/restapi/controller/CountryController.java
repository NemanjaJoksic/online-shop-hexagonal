package org.joksin.onlineshop.restapi.controller;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.FindCountriesUseCase;
import org.joksin.onlineshop.model.Country;
import org.joksin.onlineshop.restapi.dto.CountryDTO;
import org.joksin.onlineshop.restapi.mapper.CountryMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@AllArgsConstructor
public class CountryController {

    private final FindCountriesUseCase findCountriesUseCase;

    @GetMapping("/api/countries")
    public ResponseEntity<Collection<CountryDTO>> findAll() {
        Collection<Country> countries = findCountriesUseCase.findAll();
        return new ResponseEntity<>(CountryMapper.MAPPER.toDTOs(countries), HttpStatus.OK);
    }

}
