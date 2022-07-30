package org.joksin.onlineshop.rdbms;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.model.Manufacturer;
import org.joksin.onlineshop.rdbms.entity.ManufacturerEntity;
import org.joksin.onlineshop.rdbms.mapper.ManufacturerMapper;
import org.joksin.onlineshop.rdbms.repository.ManufacturerCrudRepository;
import org.joksin.onlineshop.spi.persistence.ManufacturerRepository;
import org.springframework.data.util.Streamable;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
public class ManufacturerRepositoryAdapter implements ManufacturerRepository {

    private final ManufacturerCrudRepository manufacturerCrudRepository;

    @Override
    public Collection<Manufacturer> findAll() {
        Collection<ManufacturerEntity> manufacturerEntities = Streamable.of(manufacturerCrudRepository.findAll()).toList();
        return ManufacturerMapper.MAPPER.fromEntities(manufacturerEntities);
    }

    @Override
    public Optional<Manufacturer> findById(Integer manufacturerId) {
        return manufacturerCrudRepository.findById(manufacturerId)
                .map(ManufacturerMapper.MAPPER::fromEntity);
    }

    @Override
    public Optional<Manufacturer> findByName(String manufacturerName) {
        return manufacturerCrudRepository.findByName(manufacturerName)
                .map(ManufacturerMapper.MAPPER::fromEntity);
    }

    @Override
    public Boolean existsByName(String manufacturerName) {
        return manufacturerCrudRepository.existsByName(manufacturerName);
    }

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        ManufacturerEntity createdManufacturerEntity = manufacturerCrudRepository.save(ManufacturerMapper.MAPPER.toEntity(manufacturer));
        return ManufacturerMapper.MAPPER.fromEntity(createdManufacturerEntity);
    }

}
