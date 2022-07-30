package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.CreateManufacturerUseCase;
import org.joksin.onlineshop.api.request.CreateManufacturerRequest;
import org.joksin.onlineshop.model.Country;
import org.joksin.onlineshop.model.Manufacturer;
import org.joksin.onlineshop.model.exception.ManufacturerNameExistsException;
import org.joksin.onlineshop.spi.persistence.ManufacturerRepository;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
public class CreateManufacturerUseCaseImpl implements CreateManufacturerUseCase {

    private final ManufacturerRepository manufacturerRepository;

    @Override
    @Transactional
    public Manufacturer create(CreateManufacturerRequest createManufacturerRequest) {

        String manufacturerName = createManufacturerRequest.getName();
        if(manufacturerRepository.existsByName(manufacturerName)) {
            throw new ManufacturerNameExistsException(manufacturerName);
        }

        Manufacturer manufacturer = Manufacturer.builder()
                .name(createManufacturerRequest.getName())
                .country(createManufacturerRequest.getCountry())
                .build();

        return manufacturerRepository.create(manufacturer);
    }

}
