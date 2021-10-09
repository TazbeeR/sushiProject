package pl.coderslab.sushiProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.sushiProject.entity.Order;
import pl.coderslab.sushiProject.service.OrderService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @GetMapping("/list")
    public String getListOfOrders(Model model){
        List<Order> orderList = orderService.getOrders();
        model.addAttribute("orders", orderList);
        return "/orders/list";
    }

    @GetMapping("/add")
    public String initAddOrder(Model model){
        model.addAttribute("order", new Order());
        return "/orders/form";
    }
    @PostMapping("/add")
    public String addOrder(@Valid Order order, BindingResult result){
        if (result.hasErrors()){
            return "/orders/form";
        }
        orderService.addOrder(order);
        return "redirect:/order/list";
    }

    @GetMapping("/update/{id}")
    public String initUpdateOrder(@PathVariable long id, Model model){
        model.addAttribute("order", orderService.getOrder(id));
        return "orders/form";
    }
    @PostMapping("/update/{id}")
    public String updateOrder(@Valid Order order, BindingResult result){
        if (result.hasErrors()){
            return "orders/form";
        }
        orderService.updateOrder(order);
        return "redirect:/order/list";
    }

    @GetMapping("/delete/{id}")
    public String initDeleteOrder(@PathVariable long id, Model model){
        Order order = orderService.getOrder(id).orElseThrow(EntityNotFoundException::new);
        model.addAttribute("order", order);
        return "orders/delete";
    }
    @PostMapping("/delete/{id}")
    public String deleteOrder(@RequestParam String confirmed, @RequestParam long id){
        if ("yes".equals(confirmed)){
            orderService.removeOrder(id);
        }
        return "redirect:/orders/list";
    }
}
