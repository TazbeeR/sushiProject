package pl.coderslab.sushiProject.service;

import org.springframework.stereotype.Service;
import pl.coderslab.sushiProject.entity.OrderItem;
import pl.coderslab.sushiProject.repository.OrderItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JPAOrderItemService implements OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public JPAOrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public List<OrderItem> getOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> getOrderItem(long id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public void addOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    @Override
    public void removeOrderItem(long id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }
}
