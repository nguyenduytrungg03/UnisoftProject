package com.example.projecttraining.controller;

import com.example.projecttraining.model.Customer;
import com.example.projecttraining.model.Employees;
import com.example.projecttraining.model.Product;
import com.example.projecttraining.service.customer.ICustomerService;
import com.example.projecttraining.service.security.UserDetailImp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/list")
    public String findAllCustomer(@RequestParam(required = false, defaultValue = "0") int page
            , @RequestParam(required = false, defaultValue = "") String nameCustomer
            , @RequestParam(required = false, defaultValue = "") String phoneNumberCustomer
            , Model model){
        int index = 3;

        List<Map<String, Object>> customerList = iCustomerService.findAllCustomer(nameCustomer,phoneNumberCustomer, index, index * page);
        int countCustomer = iCustomerService.countCustomer(nameCustomer,phoneNumberCustomer);
        double a = (double) countCustomer / index;
        int totalPage = (int) Math.ceil(a);
        model.addAttribute("customerList", customerList);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        model.addAttribute("index", index);
        model.addAttribute("nameCustomer", nameCustomer);
        model.addAttribute("phoneNumberCustomer", phoneNumberCustomer);
        return "customer/customer-list";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam int idCustomer, RedirectAttributes redirectAttributes){
        iCustomerService.deleteCustomer(idCustomer);
        redirectAttributes.addFlashAttribute("message", "Xóa nhân viên thành công!");
        return "redirect:/customer/list";
    }

    @GetMapping("/formCreate")
    public String goFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/customer-create";
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute("customer") Customer customer,
                                 @RequestParam(required = false, defaultValue = "") String nameCustomer,
                                 @RequestParam(required = false, defaultValue = "") String phoneNumberCustomer,
                                 @RequestParam(required = false, defaultValue = "") String addressCustomer,
                                 @RequestParam(required = false, defaultValue = "0") int page,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customer", customer);
            return "customer/customer-create";
        }
        UserDetailImp userDetails = (UserDetailImp) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int result = 0;
        try {
            result = iCustomerService.createCustomer(customer.getNameCustomer(),customer.getPhoneNumberCustomer(),customer.getAddressCustomer(),userDetails.getAccountId() -1);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        if (result == 0) {

            redirectAttributes.addFlashAttribute("message", "Thêm mới thất bại.");
            return "redirect:/customer/list?page=" + page + "&nameCustomer=" + nameCustomer + "&phoneNumberCustomer=" + phoneNumberCustomer + "&addressCustomer" +addressCustomer;
        } else {
            redirectAttributes.addFlashAttribute("message", "Thêm mới thành công.");
            return "redirect:/customer/list?page=" + page + "&nameCustomer=" + nameCustomer + "&phoneNumberCustomer=" + phoneNumberCustomer + "&addressCustomer" +addressCustomer;
        }
    }
}
