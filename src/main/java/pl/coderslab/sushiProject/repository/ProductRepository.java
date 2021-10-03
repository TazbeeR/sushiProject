package pl.coderslab.sushiProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.sushiProject.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
