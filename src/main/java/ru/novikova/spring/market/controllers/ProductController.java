package ru.novikova.spring.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.novikova.spring.market.dtos.OrderDto;
import ru.novikova.spring.market.dtos.ProductDto;
import ru.novikova.spring.market.entities.Product;
import ru.novikova.spring.market.services.OrderService;
import ru.novikova.spring.market.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll()
                .stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable(name = "id") long id) {
        return new ProductDto(productService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") long id) {
        productService.deleteById(id);
    }

}
