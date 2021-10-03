package pl.coderslab.sushiProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.sushiProject.entity.Product;
import pl.coderslab.sushiProject.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {this.productService = productService;}

    @GetMapping("/list")
    public String getListOfProducts(Model model){
        List<Product> productList = productService.getProducts();
        model.addAttribute("products", productList);
        return "/product/list";
    }

}
