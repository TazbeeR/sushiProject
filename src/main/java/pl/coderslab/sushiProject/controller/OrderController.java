package pl.coderslab.sushiProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.sushiProject.entity.DTO.UserOrderDTO;
import pl.coderslab.sushiProject.entity.Delivery;
import pl.coderslab.sushiProject.entity.Order;
import pl.coderslab.sushiProject.entity.OrderItem;
import pl.coderslab.sushiProject.entity.User;
import pl.coderslab.sushiProject.service.DeliveryService;
import pl.coderslab.sushiProject.service.OrderItemService;
import pl.coderslab.sushiProject.service.OrderService;
import pl.coderslab.sushiProject.service.UserService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/order")
public class OrderController {

    private UserService userService;
    private OrderService orderService;
    private OrderItemService orderItemService;
    private DeliveryService deliveryService;
    private UserOrderDTO userOrderDTO;

    @ModelAttribute("deliveries")
    public List<Delivery> deliveries() {
        return deliveryService.getDeliveries();
    }

    @ModelAttribute("users")
    public List<User> users() {
        return userService.getUsers();
    }


    @GetMapping("/order")
    public String initOrder(Model model) {
        model.addAttribute("userOrderDTO", new UserOrderDTO());
     //        model.addAttribute("order", new Order());
        return "order";
    }


    @PostMapping("/order")
    public String saveOrder(HttpSession session, Model model, @Valid UserOrderDTO userOrderDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "order";
        }

        userOrderDTO = (UserOrderDTO) model.getAttribute("userOrderDTO");
        User user = new User(userOrderDTO.getFirstName(), userOrderDTO.getLastName(),
                             userOrderDTO.getCity(), userOrderDTO.getPostCode(),
                             userOrderDTO.getStreet(), userOrderDTO.getNumber(),
                             userOrderDTO.getPhoneNumber(), userOrderDTO.getEmail());


//        List<User> users = userService.getUsers();
        long userId = 0;
//        for (User item : users) {
//            if (user.equals(item)){
//             userId = item.getId();
//            }else{
                userService.addUser(user);
                userId= user.getId();
//            }
//        }
        long deliveryId = userOrderDTO.getDelivery().getId();
        String payment = userOrderDTO.getPayment();
        Delivery delivery = deliveryService.getDelivery(deliveryId).orElseThrow(EntityNotFoundException::new);

//        Delivery delivery = deliveryService.getDelivery(order.getDelivery().getId()).orElseThrow(EntityNotFoundException::new);

        BigDecimal deliveryPrice = delivery.getPrice();
        BigDecimal totalPrice = new BigDecimal(String.valueOf(session.getAttribute("total")));
        BigDecimal finalPrice = totalPrice.add(deliveryPrice);

    Order order = new Order(user, delivery , payment);
        order.setFinalPrice(finalPrice);
        orderService.addOrder(order);
        long orderId = order.getId();
        List<OrderItem> orderItems = (List<OrderItem>) session.getAttribute("orderItems");
        for (OrderItem item : orderItems) {
            orderItemService.addOrderItem(item);
            long itemId = item.getId();
            orderItemService.updateOrderId(orderId, itemId);
        }
//        long userId = order.getUser().getId();
//        long deliveryId = order.getDelivery().getId();
//
        model.addAttribute("thisOrder", orderService.getOrder(orderId).orElseThrow(EmptyStackException::new));
        model.addAttribute("thisUser", userService.getUser(userId).orElseThrow(EntityNotFoundException::new));
        model.addAttribute("delivery", deliveryService.getDelivery(deliveryId).orElseThrow(EntityNotFoundException::new));
        model.addAttribute("finalPrice", (finalPrice));
        orderItems.clear();
        int cartCount = orderItems.size();
        session.setAttribute("orderItems", orderItems);
        session.setAttribute("cartCount", cartCount);
        return "addedOrder";
    }


    @GetMapping("/list")
    public String getListOfOrders(Model model) {
        List<Order> orderList = orderService.findLast50Orders();
        model.addAttribute("orders", orderList);
        return "orders";
    }

    @GetMapping("/details")
    public String detailsOfOrder(@RequestParam long id, Model model) {
        String orderDontExist;
        Order order = orderService.getOrder(id).orElseThrow(EntityNotFoundException::new);
//ify do serwisu
        if (order == null) {
            orderDontExist = "Nie ma takiego zamówienia";
            model.addAttribute("exist", orderDontExist);
            return "orders";
        }
        model.addAttribute("order", order);
        model.addAttribute("orderItems", orderItemService.selectItemOfOrder(id));
        return "details";
    }

    @GetMapping("/add")
    public String initAddOrder(Model model) {
        model.addAttribute("order", new Order());
        return "/orders/form";
    }

    @PostMapping("/add")
    public String addOrder(@Valid Order order, BindingResult result) {
        if (result.hasErrors()) {
            return "/orders/form";
        }
        orderService.addOrder(order);
        return "redirect:/order/list";
    }

    @GetMapping("/update/{id}")
    public String initUpdateOrder(@PathVariable long id, Model model) {
        model.addAttribute("order", orderService.getOrder(id));
        return "orders/form";
    }

    @PostMapping("/update/{id}")
    public String updateOrder(@Valid Order order, BindingResult result) {
        if (result.hasErrors()) {
            return "orders/form";
        }
        orderService.updateOrder(order);
        return "redirect:/order/list";
    }

    @GetMapping("/delete/{id}")
    public String initDeleteOrder(@PathVariable long id, Model model) {
        Order order = orderService.getOrder(id).orElseThrow(EntityNotFoundException::new);
        model.addAttribute("order", order);
        return "orders/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteOrder(@RequestParam String confirmed, @RequestParam long id) {
        if ("yes".equals(confirmed)) {
            orderService.removeOrder(id);
        }
        return "redirect:/orders/list";
    }
}
