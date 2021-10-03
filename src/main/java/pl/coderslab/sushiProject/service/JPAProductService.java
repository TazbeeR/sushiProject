package pl.coderslab.sushiProject.service;

import org.springframework.stereotype.Service;
import pl.coderslab.sushiProject.entity.Product;
import pl.coderslab.sushiProject.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JPAProductService implements ProductService{
    private final ProductRepository productRepository;

    public JPAProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProduct(long id) {
        return productRepository.findById(id);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void removeProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }
}
