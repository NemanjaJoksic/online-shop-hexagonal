package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.CreateManufacturerUseCase;
import org.joksin.onlineshop.api.request.CreateManufacturerRequest;
import org.joksin.onlineshop.model.Manufacturer;

@AllArgsConstructor
public class CreateManufacturerUseCaseImpl implements CreateManufacturerUseCase {

    @Override
    public Manufacturer create(CreateManufacturerRequest createManufacturerRequest) {
        return null;
    }

}
