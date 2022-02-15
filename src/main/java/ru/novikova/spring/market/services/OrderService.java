package ru.novikova.spring.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.novikova.spring.market.dtos.OrderDto;
import ru.novikova.spring.market.dtos.ProductDto;
import ru.novikova.spring.market.entities.Order;
import ru.novikova.spring.market.entities.Product;
import ru.novikova.spring.market.repositories.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order findOrderByTitle(String s) {
        return orderRepository.findOrderByTitle(s);
    }
}
