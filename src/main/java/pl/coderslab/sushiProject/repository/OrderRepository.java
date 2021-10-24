package pl.coderslab.sushiProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.sushiProject.entity.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select * from orders order by id desc limit 5", nativeQuery = true)
    List<Order> findLast50Orders();

}
