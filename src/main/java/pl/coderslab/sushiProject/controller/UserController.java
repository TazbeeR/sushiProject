package pl.coderslab.sushiProject.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.sushiProject.entity.Address;
import pl.coderslab.sushiProject.entity.User;
import pl.coderslab.sushiProject.service.AddressService;
import pl.coderslab.sushiProject.service.UserService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private AddressService addressService;

    @ModelAttribute("addresses")
    public List<Address> addresses() {return addressService.getAddresses();}

    @GetMapping("/list")
    public String getUsers(Model model){
        List<User> userList = userService.getUsers();
        model.addAttribute("users", userList);
        return "/users/list";
    }

    @GetMapping("/add")
    public String initAddUser(Model model){
        model.addAttribute("user", new User());
        return "users/form";
    }

    @PostMapping("/add")
    public String addUser(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "users/form";
        }
        userService.addUser(user);
        return "redirect:/order/order";
    }

    @GetMapping("/update/{id}")
    public String initUpdateUser(Model model, @PathVariable long id){
        model.addAttribute("user", userService.getUser(id));
        return "users/form";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "users/form";
        }
        userService.updateUser(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete/{id}")
    public String initDeleteUser(Model model, @PathVariable long id){
        User user = userService.getUser(id).orElseThrow(EntityNotFoundException::new);
        model.addAttribute("user", user);
        return "users/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@RequestParam String confirmed, @RequestParam long id){
        if ("yes".equals(confirmed)){
            userService.removeUser(id);
        }
        return "redirect:/user/list";
    }
}
