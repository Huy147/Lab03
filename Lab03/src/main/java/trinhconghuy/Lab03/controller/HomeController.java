package trinhconghuy.Lab03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
    public HomeController() {
    }

    @GetMapping
    public String HomePage() {
        return "home/index";
    }


}