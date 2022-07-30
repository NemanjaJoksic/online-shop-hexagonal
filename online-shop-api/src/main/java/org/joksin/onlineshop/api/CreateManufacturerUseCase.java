package org.joksin.onlineshop.api;

import org.joksin.onlineshop.api.request.CreateManufacturerRequest;
import org.joksin.onlineshop.model.Manufacturer;

public interface CreateManufacturerUseCase {

    Manufacturer create(CreateManufacturerRequest createManufacturerRequest);

}
