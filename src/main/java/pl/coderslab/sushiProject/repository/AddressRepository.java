package pl.coderslab.sushiProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.sushiProject.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
