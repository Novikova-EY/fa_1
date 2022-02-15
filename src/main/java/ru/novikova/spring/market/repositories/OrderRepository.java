package ru.novikova.spring.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.novikova.spring.market.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    public Order findOrderByTitle(String title);

}
