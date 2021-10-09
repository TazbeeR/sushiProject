package pl.coderslab.sushiProject.service;

import org.springframework.stereotype.Service;
import pl.coderslab.sushiProject.entity.Order;
import pl.coderslab.sushiProject.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JPAOrderService implements OrderService{
    private final OrderRepository orderRepository;

    public JPAOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrder(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void removeOrder(long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void updateOrder(Order order) {
        orderRepository.save(order);
    }
}
