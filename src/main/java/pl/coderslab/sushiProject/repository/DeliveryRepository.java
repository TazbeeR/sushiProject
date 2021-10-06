package pl.coderslab.sushiProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.sushiProject.entity.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery ,Long> {
}
