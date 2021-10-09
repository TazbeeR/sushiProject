package pl.coderslab.sushiProject.service;

import pl.coderslab.sushiProject.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getOrders();
    Optional<Order> getOrder(long id);
    void addOrder (Order order);
    void removeOrder (long id);
    void updateOrder (Order order);
}
