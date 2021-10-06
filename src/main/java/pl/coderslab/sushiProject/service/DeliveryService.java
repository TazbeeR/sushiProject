package pl.coderslab.sushiProject.service;

import pl.coderslab.sushiProject.entity.Delivery;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {

    List<Delivery> getDeliveries();
    Optional<Delivery> getDelivery(long id);
    void addDelivery (Delivery delivery);
    void removeDelivery(long id);
    void updateDelivery(Delivery delivery);
}
