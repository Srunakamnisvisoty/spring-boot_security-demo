package ru.kata.spring.boot_security.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@AllArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping
    public String allUsers(ModelMap modelMap) {
        modelMap.addAttribute("userList", userService.findAll());
        return "user_list";
    }

    @GetMapping("/update/{id}")
    public String preUpdate(ModelMap modelMap, @PathVariable("id") Long id) {
        modelMap.addAttribute("user", userService.findOne(id));
        return "user_manage";
    }

    @GetMapping("/create")
    public String preCreate(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "user_manage";
    }

//    @PostMapping("/create")
//    public String create(@ModelAttribute User user) {
//        userService.save(user);
//        return "redirect:/user_list";
//    }

    @PostMapping({"create","/update"})
    public String update(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/user_list";
    }

    @PostMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        userService.remove(id);
        return "redirect:/user_list";
    }
}
