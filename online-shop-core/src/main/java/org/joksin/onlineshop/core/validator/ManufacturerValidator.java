package org.joksin.onlineshop.core.validator;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.model.exception.ManufacturerExistsException;
import org.joksin.onlineshop.model.exception.ManufacturerNotExistException;
import org.joksin.onlineshop.spi.persistence.ManufacturerRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManufacturerValidator {

    private final ManufacturerRepository manufacturerRepository;

    public void validateManufacturerExists(Integer manufacturerId) {
        Boolean exists = manufacturerRepository.existsById(manufacturerId);
        if (!exists) {
            throw new ManufacturerNotExistException(manufacturerId);
        }
    }

    public void validateManufacturerNotExist(String manufacturerName) {
        Boolean exists = manufacturerRepository.existsByName(manufacturerName);
        if (exists) {
            throw new ManufacturerExistsException(manufacturerName);
        }
    }

}
