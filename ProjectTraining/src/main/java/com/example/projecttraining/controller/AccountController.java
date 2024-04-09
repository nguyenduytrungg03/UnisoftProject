package com.example.projecttraining.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AccountController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String showFormLogin(){
        return "login";
    }
    @GetMapping("")
    public String loginSuccess() {
        return "test";
    }

}
