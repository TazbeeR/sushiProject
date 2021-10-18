package pl.coderslab.sushiProject.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.sushiProject.entity.OrderItem;
import pl.coderslab.sushiProject.entity.Product;
import pl.coderslab.sushiProject.service.OrderItemService;
import pl.coderslab.sushiProject.service.ProductService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/orderItem")
public class OrderItemController {
    @Autowired
    private ProductService productService;
    private OrderItemService orderItemService;
    private List<OrderItem> orderItems = new ArrayList<>();
    private int cartCount;

    @GetMapping("/list")
    public String getListOfOrderItems(HttpSession session) {

        session.setAttribute("total", totalPrice());
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String initAddOrderItem(@PathVariable long id, HttpSession session) {
        Product product = productService.getProduct(id).orElseThrow(EntityNotFoundException::new);

        if (orderItems.size() == 0) {
            OrderItem orderItem = new OrderItem(1, product);
            orderItems.add(orderItem);
        } else {
            boolean ifProductAlreadyExistInOrder = true;

            for (OrderItem item : orderItems) {
                if (item.getProduct().getId() == product.getId()) {
                    item.setQuantity(item.getQuantity() + 1);
                    ifProductAlreadyExistInOrder = false;
                }
            }
            if (ifProductAlreadyExistInOrder) {
                OrderItem orderItem = new OrderItem(1, product);
                orderItems.add(orderItem);
            }
        }
        cartCount = orderItems.size();
        session.setAttribute("orderItems", orderItems);
        session.setAttribute("cartCount", cartCount);
        return "redirect:/product/list";
    }

    @GetMapping("/plus/{name}")
    public String plusProductToOrder(@PathVariable String name) {
        for (OrderItem item : orderItems) {
            if (item.getProduct().getName().equals(name)) {
                item.setQuantity(item.getQuantity() + 1);
            }
        }
        return "redirect:/orderItem/list";
    }

    @GetMapping("/minus/{name}")
    public String minusProductFromOrder(@PathVariable String name, HttpSession session) {
        for (Iterator<OrderItem> it = orderItems.iterator(); it.hasNext(); ) {
            OrderItem item = it.next();
            if (item.getProduct().getName().equals(name)) {
                if (item.getQuantity() > 1) {
                    item.setQuantity(item.getQuantity() - 1);
                } else if (item.getQuantity() == 1) {
                    it.remove();
                }
            }
        }
        cartCount = orderItems.size();
        session.setAttribute("cartCount", cartCount);
        return "redirect:/orderItem/list";
    }

    public BigDecimal totalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem item : orderItems) {
            BigDecimal itemCost = item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            total = total.add(itemCost);
        }
        return total;
    }
}
