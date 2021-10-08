package pl.coderslab.sushiProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.sushiProject.entity.Product;
import pl.coderslab.sushiProject.service.ProductService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;


    @GetMapping("/list")
    public String getListOfProducts(Model model){
        List<Product> productList = productService.getProducts();
        model.addAttribute("products", productList);
        return "/products/list";
    }

    @GetMapping("/add")
    public String initAddProduct(Model model){
        model.addAttribute("product", new Product());
        return "products/form";
    }
    @PostMapping("/add")
    public String addProduct(@Valid Product product, BindingResult result){
        if (result.hasErrors()){
            return "products/form";
        }
         productService.addProduct(product);
         return "redirect:/product/list";
    }

    @GetMapping("/update/{id}")
    public String initUpdateProduct(Model model, @PathVariable long id){
        model.addAttribute("product", productService.getProduct(id));
        return "products/form";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@Valid Product product, BindingResult result){
        if (result.hasErrors()) {
            return "products/form";
        }
        productService.updateProduct(product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{id}")
    public String initDeleteProduct(@PathVariable long id, Model model){
        Product product = productService.getProduct(id).orElseThrow(EntityNotFoundException::new);
        model.addAttribute("product", product);
        return "products/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@RequestParam String confirmed, @RequestParam long id ){
        if ("yes".equals(confirmed)){
            productService.removeProduct(id);
        }
        return "redirect:/product/list";
    }
}
