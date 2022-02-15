package ru.novikova.spring.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.novikova.spring.market.dtos.OrderDto;
import ru.novikova.spring.market.entities.Order;
import ru.novikova.spring.market.entities.Product;
import ru.novikova.spring.market.services.OrderService;
import ru.novikova.spring.market.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;

    @GetMapping
    public List<OrderDto> findAll() {
        return orderService.findAll()
                .stream()
                .map(OrderDto::new)
                .collect(Collectors.toList());
    }

    @PutMapping("/add/{id}")
    public OrderDto add(@PathVariable(name = "id") long id) {
        Order order = orderService.findOrderByTitle("Order 1");
        List<Product> orderProducts = order.getProducts();
        orderProducts.add(productService.findById(id));
        order.setProducts(orderProducts);
        orderService.save(order);
        return new OrderDto(order);
    }
}

