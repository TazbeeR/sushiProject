package pl.coderslab.sushiProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class WebsiteController {

    @GetMapping("/")
    public String landingPage(HttpSession session){

        return "index";
    }
    @GetMapping("/contact")
    public String contactPage(){
        return "/contact";
    }
}
