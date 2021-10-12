package pl.coderslab.sushiProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteController {
    @GetMapping("/contact")
    public String contactPage(){
        return "/contact";
    }
}
