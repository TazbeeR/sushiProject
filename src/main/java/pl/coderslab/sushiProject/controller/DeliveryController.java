package pl.coderslab.sushiProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.sushiProject.entity.Delivery;
import pl.coderslab.sushiProject.service.DeliveryService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/delivery")
public class DeliveryController {

    private DeliveryService deliveryService;


    @GetMapping("/list")
    public String getListOfDeliveries(Model model){
        List<Delivery> deliveryList = deliveryService.getDeliveries();
        model.addAttribute("deliveries", deliveryList);
        return "/deliveries/list";
    }

    @GetMapping("/add")
    public String initAddDelivery(Model model){
        model.addAttribute("delivery", new Delivery());
        return "deliveries/form";
    }
    @PostMapping("/add")
    public String addDelivery(@Valid Delivery delivery, BindingResult result){
        if (result.hasErrors()){
            return "deliveries/form";
        }
        deliveryService.addDelivery(delivery);
        return "redirect:/delivery/list";
    }

    @GetMapping("/update/{id}")
    public String initUpdateDelivery(Model model, @PathVariable long id){
        model.addAttribute("delivery", deliveryService.getDelivery(id));
        return "deliveries/form";
    }

    @PostMapping("/update/{id}")
    public String updateDelivery(@Valid Delivery delivery, BindingResult result){
        if (result.hasErrors()) {
            return "deliveries/form";
        }
        deliveryService.updateDelivery(delivery);
        return "redirect:/delivery/list";
    }

    @GetMapping("/delete/{id}")
    public String initDeleteDelivery(@PathVariable long id, Model model){
        Delivery delivery = deliveryService.getDelivery(id).orElseThrow(EntityNotFoundException::new);
        model.addAttribute("delivery", delivery);
        return "deliveries/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteDelivery(@RequestParam String confirmed, @RequestParam long id ){
        if ("yes".equals(confirmed)){
            deliveryService.removeDelivery(id);
        }
        return "redirect:/delivery/list";
    }
}
