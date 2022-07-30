package org.joksin.onlineshop.restapi.controller;

import lombok.AllArgsConstructor;
import org.joksin.onlineshop.api.ChangeProductPriceUseCase;
import org.joksin.onlineshop.api.CreateProductUseCase;
import org.joksin.onlineshop.api.FindProductUseCase;
import org.joksin.onlineshop.api.FindProductsUseCase;
import org.joksin.onlineshop.model.Product;
import org.joksin.onlineshop.restapi.dto.ChangeProductPriceRequestDTO;
import org.joksin.onlineshop.restapi.dto.CreateProductRequestDTO;
import org.joksin.onlineshop.restapi.dto.ProductDTO;
import org.joksin.onlineshop.restapi.mapper.ChangeProductPriceRequestMapper;
import org.joksin.onlineshop.restapi.mapper.CreateProductRequestMapper;
import org.joksin.onlineshop.restapi.mapper.ProductMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final ChangeProductPriceUseCase changeProductPriceUseCase;
    private final FindProductUseCase findProductUseCase;
    private final FindProductsUseCase findProductsUseCase;

    @PostMapping("/api/products")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody CreateProductRequestDTO createProductRequestDto) {
        Product product = createProductUseCase.create(CreateProductRequestMapper.MAPPER.fromDTO(createProductRequestDto));
        return new ResponseEntity<>(ProductMapper.MAPPER.toDTO(product), HttpStatus.CREATED);
    }

    @PutMapping("/api/products/price")
    public ResponseEntity<ProductDTO> changeProductPrice(@RequestBody ChangeProductPriceRequestDTO changeProductPriceRequestDto) {
        Product updatedProduct = changeProductPriceUseCase.changePrice(ChangeProductPriceRequestMapper.MAPPER.fromDTO(changeProductPriceRequestDto));
        return new ResponseEntity<>(ProductMapper.MAPPER.toDTO(updatedProduct), HttpStatus.OK);
    }

    @GetMapping("/api/products")
    public ResponseEntity<Collection<ProductDTO>> findAll() {
        Collection<Product> products = findProductsUseCase.findAll();
        if (!products.isEmpty()) {
            return new ResponseEntity<>(ProductMapper.MAPPER.toDTOs(products), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/api/products/{productId}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Integer productId) {
        Optional<Product> productOptional = findProductUseCase.findById(productId);
        return productOptional.map(product -> new ResponseEntity<>(ProductMapper.MAPPER.toDTO(product), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

}
