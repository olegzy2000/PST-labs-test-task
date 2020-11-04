package com.webLibrary.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model){
        return "home";// по названию мы вызываем определенный шаблон
    }
    @GetMapping("/about")
    public String about(Model model){
        return "about";
    }
}
