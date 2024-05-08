package com.example.projecttraining.restController;

import com.example.projecttraining.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/phone")
    String getNameCustomerByPhoneNumberCustomer(@RequestParam String phoneNumberCustomer){
        return iCustomerService.getNameByPhone(phoneNumberCustomer);
    }

    @GetMapping("/name")
    String getPhoneNumberCustomerByNameCustomer(@RequestParam String nameCustomer){
        return iCustomerService.getPhoneByName(nameCustomer);
    }
}
