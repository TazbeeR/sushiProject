package pl.coderslab.sushiProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.sushiProject.entity.Address;
import pl.coderslab.sushiProject.service.AddressService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
@AllArgsConstructor
@Controller
@RequestMapping("/address")
public class AddressController {
    private AddressService addressService;

    @GetMapping("/list")
    public String getListOfAddresses (Model model){
        List<Address> addressList = addressService.getAddresses();
        model.addAttribute("addresses", addressList);
        return "/addresses/list";
    }

    @GetMapping("/add")
    public String intAddAddress(Model model){
        model.addAttribute("address", new Address());
        return "addresses/form";
    }

    @PostMapping("/add")
    public String addAddress(@Valid Address address, BindingResult result){
        if (result.hasErrors()){
            return "addresses/form";
        }
        addressService.addAddress(address);
        return "redirect:/address/list";
    }

    @GetMapping("/update/{id}")
    public String initUpdateAddress(Model model, @PathVariable long id){
        model.addAttribute("address", addressService.getAddress(id));
        return "addresses/form";
    }

    @PostMapping("/update/{id}")
    public String updateAddress(@Valid Address address, BindingResult result){
        if (result.hasErrors()){
            return "addresses/form";
        }
        addressService.updateAddress(address);
        return "redirect:/address/list";
    }

    @GetMapping("/delete/{id}")
    public String initDeleteAddress(@PathVariable long id, Model model){
        Address address = addressService.getAddress(id).orElseThrow(EntityNotFoundException::new);
        model.addAttribute("address", address);
        return "addresses/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteAddress(@RequestParam String confirmed, @RequestParam long id){
        if ("yes".equals(confirmed)){
            addressService.removeAddress(id);
        }
        return "redirect:/address/list";
    }
}
