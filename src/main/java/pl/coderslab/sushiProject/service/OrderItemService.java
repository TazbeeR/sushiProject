package pl.coderslab.sushiProject.service;

import pl.coderslab.sushiProject.entity.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemService {

    List<OrderItem> getOrderItems();
    Optional<OrderItem> getOrderItem(long id);
    void addOrderItem (OrderItem orderItem);
    void removeOrderItem (long id);
    void updateOrderItem (OrderItem orderItem);
}
