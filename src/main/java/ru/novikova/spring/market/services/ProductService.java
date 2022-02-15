package ru.novikova.spring.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.novikova.spring.market.entities.Product;
import ru.novikova.spring.market.repositories.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(long id) {
        return productRepository.findById(id).get();
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}
