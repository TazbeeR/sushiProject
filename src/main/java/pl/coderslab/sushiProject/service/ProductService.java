package pl.coderslab.sushiProject.service;

import pl.coderslab.sushiProject.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getProducts();
    Optional<Product> getProduct(long id);
    void addProduct(Product product);
    void removeProduct(long id);
    void updateProduct(Product product);

}
