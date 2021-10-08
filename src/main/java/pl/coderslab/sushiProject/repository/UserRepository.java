package pl.coderslab.sushiProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.sushiProject.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
