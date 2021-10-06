package pl.coderslab.sushiProject.service;

import org.springframework.stereotype.Service;
import pl.coderslab.sushiProject.entity.Delivery;
import pl.coderslab.sushiProject.repository.DeliveryRepository;

import java.util.List;
import java.util.Optional;
@Service
public class JPADeliveryService implements DeliveryService{
    private final DeliveryRepository deliveryRepository;

    public JPADeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public List<Delivery> getDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public Optional<Delivery> getDelivery(long id) {
        return deliveryRepository.findById(id);
    }

    @Override
    public void addDelivery(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    @Override
    public void removeDelivery(long id) {
        deliveryRepository.deleteById(id);
    }

    @Override
    public void updateDelivery(Delivery delivery) {
        deliveryRepository.save(delivery);
    }
}
