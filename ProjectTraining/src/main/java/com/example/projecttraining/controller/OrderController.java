package com.example.projecttraining.controller;


import com.example.projecttraining.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;


//    @GetMapping("/list")
//    public String getAllOrder()
}
