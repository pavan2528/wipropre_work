package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/userreg")
    public String showForm() {
        return "userreg";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        System.out.println("User Data: " + user);
        return "success";
    }
}
