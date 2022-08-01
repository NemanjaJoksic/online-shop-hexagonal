package org.joksin.onlineshop.rdbms;

import commons.DateTimeUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.model.filter.RangeValue;
import org.joksin.onlineshop.model.filter.SearchProductsFilter;
import org.joksin.onlineshop.rdbms.entity.ProductEntity;
import org.joksin.onlineshop.rdbms.entity.mapper.ProductEntityRowMapper;
import org.joksin.onlineshop.rdbms.mapper.ProductMapper;
import org.joksin.onlineshop.rdbms.mapper.ProductTypeMapper;
import org.joksin.onlineshop.rdbms.repository.ManufacturerCrudRepository;
import org.joksin.onlineshop.rdbms.repository.ProductCrudRepository;
import org.joksin.onlineshop.spi.persistence.ProductRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.jooq.impl.DSL;
import org.springframework.data.util.Streamable;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.jooq.impl.DSL.field;

@Slf4j
@AllArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductCrudRepository productCrudRepository;
    private final ManufacturerCrudRepository manufacturerCrudRepository;

    private final JdbcTemplate jdbcTemplate;
    private final DSLContext dsl;

    private final ProductEntityRowMapper productEntityRowMapper;

    @Override
    public Optional<Product> findById(Integer productId) {
        return productCrudRepository.findById(productId)
                .map(this::toProductWithManufacturer);
    }

    @Override
    public Collection<Product> findAll(SearchProductsFilter searchProductsFilter) {

        // build where cause
        Condition where = DSL.noCondition();
        if (searchProductsFilter.getName() != null) {
            where = where.and(field("product.name").eq(searchProductsFilter.getName()));
        }

        if (searchProductsFilter.getTypes() != null) {
            where = where.and(field("product.type_id").in(ProductTypeMapper.MAPPER.toIds(searchProductsFilter.getTypes())));
        }

        RangeValue<Double> priceRange = searchProductsFilter.getPriceRange();
        if (priceRange.getFrom() != null) {
            where = where.and(field("product.price").ge(priceRange.getFrom()));
        }
        if (priceRange.getTo() != null) {
            where = where.and(field("product.price").le(priceRange.getTo()));
        }

        if (searchProductsFilter.getManufacturerIds() != null){
            where = where.and(field("product.manufacturer_id").in(searchProductsFilter.getManufacturerIds()));
        }

        Query query = dsl.selectFrom("product").where(where);

        String sql = query.getSQL();
        List<Object> bindValues = query.getBindValues();

        log.info("SQL: {}", sql);
        log.info("BindValues: {}", bindValues);

        List<ProductEntity> productEntities = jdbcTemplate.query(sql, productEntityRowMapper, bindValues.toArray());
        return toProductsWithManufacturer(productEntities);
    }

    @Override
    public Collection<Product> findAllByManufacturerId(Integer manufacturerId) {
        Collection<ProductEntity> productEntities = Streamable.of(productCrudRepository.findAllByManufacturerId(manufacturerId)).toList();
        return toProductsWithManufacturer(productEntities);
    }

    @Override
    public Boolean existsById(Integer productId) {
        return productCrudRepository.existsById(productId);
    }

    @Override
    public Boolean existsByNameAndManufacturerId(String productName, Integer manufacturerId) {
        return productCrudRepository.existsByNameAndManufacturerId(productName, manufacturerId);
    }

    @Override
    public Product create(Product product) {
        ProductEntity createdProductEntity = productCrudRepository.save(ProductMapper.MAPPER.toEntity(product));
        return toProductWithManufacturer(createdProductEntity);
    }

    @Override
    public Product changePrice(Integer productId, double newPrice) {
        Integer rowsUpdated = productCrudRepository.updatePriceById(newPrice, DateTimeUtil.getNowUTC(), productId);
        if (rowsUpdated != 1) {
            throw new RuntimeException("Unexpected number of row(s) updated. Expected to have 1 row updated, but was " + rowsUpdated);
        }

        return findById(productId)
                .orElseThrow(() -> new RuntimeException("Inconsistent data: product with ID " + productId + " must exist in the database"));
    }

    private Collection<Product> toProductsWithManufacturer(Collection<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(this::toProductWithManufacturer)
                .collect(Collectors.toList());
    }

    private Product toProductWithManufacturer(ProductEntity productEntity) {
        return manufacturerCrudRepository.findById(productEntity.getManufacturerId())
                .map(manufacturerEntity -> ProductMapper.MAPPER.fromEntity(productEntity, manufacturerEntity))
                .orElseThrow(() -> new RuntimeException("Inconsistent data: manufacturer with ID " + productEntity.getManufacturerId() + " must exist in the database"));
    }

}
