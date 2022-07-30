package org.joksin.onlineshop.restapi.controller;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.CreateManufacturerUseCase;
import org.joksin.onlineshop.api.FindManufacturerUseCase;
import org.joksin.onlineshop.api.FindManufacturersUseCase;
import org.joksin.onlineshop.api.request.CreateManufacturerRequest;
import org.joksin.onlineshop.model.Manufacturer;
import org.joksin.onlineshop.restapi.dto.CreateManufacturerRequestDTO;
import org.joksin.onlineshop.restapi.dto.ManufacturerDTO;
import org.joksin.onlineshop.restapi.mapper.CreateManufacturerRequestMapper;
import org.joksin.onlineshop.restapi.mapper.ManufacturerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ManufacturerController {

    private final FindManufacturersUseCase findManufacturersUseCase;
    private final FindManufacturerUseCase findManufacturerUseCase;
    private final CreateManufacturerUseCase createManufacturerUseCase;

    @PostMapping("/api/manufacturers")
    public ResponseEntity<ManufacturerDTO> create(@RequestBody CreateManufacturerRequestDTO createManufacturerRequestDto) {
        CreateManufacturerRequest createManufacturerRequest = CreateManufacturerRequestMapper.MAPPER.fromDTO(createManufacturerRequestDto);
        Manufacturer manufacturer = createManufacturerUseCase.create(createManufacturerRequest);
        System.out.println(manufacturer.getCountry());
        return new ResponseEntity<>(ManufacturerMapper.MAPPER.toDTO(manufacturer), HttpStatus.CREATED);
    }

    @GetMapping("/api/manufacturers")
    public ResponseEntity<Collection<ManufacturerDTO>> findAll() {
        Collection<Manufacturer> manufacturers = findManufacturersUseCase.findAll();
        if(!manufacturers.isEmpty()) {
            return new ResponseEntity<>(ManufacturerMapper.MAPPER.toDTOs(manufacturers), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/api/manufacturers/{manufacturerId}")
    public ResponseEntity<ManufacturerDTO> findById(@PathVariable Integer manufacturerId) {
        Optional<Manufacturer> manufacturerOptional = findManufacturerUseCase.findById(manufacturerId);
        return manufacturerOptional.map(manufacturer -> new ResponseEntity<>(ManufacturerMapper.MAPPER.toDTO(manufacturer), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

}
