package PSpringStudy.springStudy211217.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
