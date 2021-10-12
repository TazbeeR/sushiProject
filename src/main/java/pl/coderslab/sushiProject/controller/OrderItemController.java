package pl.coderslab.sushiProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.sushiProject.entity.OrderItem;
import pl.coderslab.sushiProject.service.OrderItemService;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/orderItem")
public class OrderItemController {

    private OrderItemService orderItemService;

    @GetMapping("/list")
    public String getListOfOrderItems(Model model){
        List<OrderItem> orderItemList = orderItemService.getOrderItems();
        model.addAttribute("orderItems", orderItemList);
        return "basket";
    }

    @GetMapping("/add")
    public String initAddOrderItem(Model model){
        model.addAttribute("orderItem", new OrderItem());
        return "/orderItems/form";
    }
    @PostMapping("/add")
    public String addOrderItem(@Valid OrderItem orderItem, BindingResult result){
        if (result.hasErrors()){
            return "/orderItems/form";
        }
        orderItemService.addOrderItem(orderItem);
        return "redirect:/orderItem/list";
    }

    @GetMapping("/update/{id}")
    public String initUpdateOrderItems(@PathVariable long id, Model model){
        model.addAttribute("orderItem", orderItemService.getOrderItem(id));
        return "orderItems/form";
    }
    @PostMapping("/update/{id}")
    public String updateOrderItem(@Valid OrderItem orderItem, BindingResult result){
        if (result.hasErrors()){
            return "orderItems/form";
        }
        orderItemService.updateOrderItem(orderItem);
        return "redirect:/orderItem/list";
    }

    @GetMapping("/delete/{id}")
    public String deteteOrderItem(@PathVariable long id){
        orderItemService.removeOrderItem(id);
        return "redirect:/orderItem/list";
    }
}
