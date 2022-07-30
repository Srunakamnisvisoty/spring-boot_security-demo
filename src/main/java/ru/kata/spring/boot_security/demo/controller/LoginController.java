package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class LoginController {

    @GetMapping({"/", "/login"})
    public String login(ModelMap modelMap) {
        return "login";
    }

    @GetMapping("/loginerror")
    public String loginError(ModelMap modelMap) {
        modelMap.addAttribute("loginError", true);
        return "login";
    }
}
