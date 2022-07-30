package org.joksin.onlineshop.core;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.api.CreateProductUseCase;
import org.joksin.onlineshop.api.request.CreateProductRequest;
import org.joksin.onlineshop.core.util.DateTimeUtil;
import org.joksin.onlineshop.core.validator.ManufacturerValidator;
import org.joksin.onlineshop.core.validator.ProductValidator;
import org.joksin.onlineshop.model.Manufacturer;
import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.spi.persistence.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@AllArgsConstructor
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepository productRepository;
    private final ManufacturerValidator manufacturerValidator;
    private final ProductValidator productValidator;

    @Override
    @Transactional
    public Product create(CreateProductRequest createProductRequest) {

        manufacturerValidator.validateManufacturerExists(createProductRequest.getManufacturerId());
        productValidator.validateProductNotExist(createProductRequest.getName(), createProductRequest.getManufacturerId());

        Product product = Product.builder()
                .name(createProductRequest.getName())
                .manufacturer(Manufacturer.of(createProductRequest.getManufacturerId()))
                .price(createProductRequest.getPrice())
                .type(createProductRequest.getProductType())
                .lastUpdated(DateTimeUtil.getNowUTC())
                .build();

        return productRepository.create(product);
    }

}
