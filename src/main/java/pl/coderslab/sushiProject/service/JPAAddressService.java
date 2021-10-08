package pl.coderslab.sushiProject.service;

import org.springframework.stereotype.Service;
import pl.coderslab.sushiProject.entity.Address;
import pl.coderslab.sushiProject.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JPAAddressService implements AddressService{
    private final AddressRepository addressRepository;

    public JPAAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getAddress(long id) {
        return addressRepository.findById(id);
    }

    @Override
    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void removeAddress(long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public void updateAddress(Address address) {
        addressRepository.save(address);
    }
}
