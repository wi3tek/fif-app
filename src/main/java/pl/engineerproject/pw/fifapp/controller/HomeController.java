package pl.engineerproject.pw.fifapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
//home
    @GetMapping({"/","/home"})
    public String getHome() {
        return "index";
    }
}
