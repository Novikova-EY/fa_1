package ru.novikova.spring.market.dtos;

import lombok.Data;
import ru.novikova.spring.market.entities.Order;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class OrderDto {
    private long id;
    private String title;
    private List<ProductDto> products;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.title = order.getTitle();
        this.products = order.getProducts().stream().map(ProductDto::new).collect(Collectors.toList());
    }
}
