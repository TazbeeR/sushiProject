package pl.coderslab.sushiProject.service;

import pl.coderslab.sushiProject.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> getAddresses();
    Optional<Address> getAddress(long id);
    void addAddress(Address address);
    void removeAddress(long id);
    void updateAddress(Address address);
}
