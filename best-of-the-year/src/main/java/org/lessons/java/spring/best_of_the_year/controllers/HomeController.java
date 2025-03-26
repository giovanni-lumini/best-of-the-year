package org.lessons.java.spring.best_of_the_year.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")

public class HomeController {

    @GetMapping("/")
    /* http://localhost:8080/?name=Giovanni */
    public String home(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }
}
