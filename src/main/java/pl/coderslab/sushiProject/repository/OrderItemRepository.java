package pl.coderslab.sushiProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.sushiProject.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
