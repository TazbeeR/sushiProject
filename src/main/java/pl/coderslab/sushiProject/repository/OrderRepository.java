package pl.coderslab.sushiProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.sushiProject.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
