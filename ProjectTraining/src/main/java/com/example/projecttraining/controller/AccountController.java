package com.example.projecttraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AccountController {

    @GetMapping("/login")
    public String showFormLogin(){
        return "login";
    }

}
