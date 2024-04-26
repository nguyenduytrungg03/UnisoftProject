package com.example.projecttraining.controller;

import com.example.projecttraining.model.Account;
import com.example.projecttraining.model.Employees;
import com.example.projecttraining.service.account.IAccountService;
import com.example.projecttraining.service.employees.IEmployeesService;
import com.example.projecttraining.service.order.IOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/order")			
public class OrderController {

    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private IEmployeesService iEmployeesService;

    private Account getAccountLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String usernameLogin = authentication.getName();
            Account account = iAccountService.findByAccountName(usernameLogin);
            return account;
        }
        return null;
    }
    @GetMapping("/list")
    public String getAllListOrder(@RequestParam(required = false, defaultValue = "0") int    page,
                                  @RequestParam(required = false, defaultValue = "") String  accountName,
                                  @RequestParam(required = false, defaultValue = "") String  nameEmployees,
                                  @RequestParam(required = false, defaultValue = "") String  codeProduct,
                                  @RequestParam(required = false, defaultValue = "") String  nameProduct,
                                  @RequestParam(required = false, defaultValue = "") String  nameCustomer,
                                  @RequestParam(required = false, defaultValue = "") String  phoneNumberCustomer,
                                  @RequestParam(required = false, defaultValue = "") String  dayOrderStart,
                                  @RequestParam(required = false, defaultValue = "") String  dayOrderEnd,
                                  @RequestParam(required = false, defaultValue = "") String nameStatus,
                                  Model model) {
        Account accountLogin = getAccountLogin();
        assert accountLogin != null;
        Employees employees = iEmployeesService.getEmployeesByAccountId(accountLogin.getAccountId());
        int idEmployees = employees.getIdEmployees();
        if (dayOrderStart.isEmpty()) {
            dayOrderStart = "2010-07-01";
        }
        if (dayOrderEnd.isEmpty()) {
            dayOrderEnd = "9999-12-31";
        }
//        if (allocatedStatus == 0 && orderedStatus == 0 ) {
//            orderedStatus = 1;
//            allocatedStatus =2 ;
//        }
        int index = 3;
        List<Map<String,Object>> orderList = iOrderService.getAllOrder( accountName, nameEmployees,
                                                                        codeProduct, nameProduct,
                                                                        nameCustomer, phoneNumberCustomer,
                                                                        idEmployees , LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd),
                                                                        nameStatus,
                                                                        index, index * page );
        int countOrder = iOrderService.countOrder( accountName, nameEmployees,
                                                   codeProduct, nameProduct,
                                                   nameCustomer, phoneNumberCustomer,
                                                   idEmployees , LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd),
                                                   nameStatus);
        double temp = (double) countOrder / index;
        int totalPage = (int) Math.ceil(temp);
        model.addAttribute("orderList", orderList);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        model.addAttribute("index", index);
        model.addAttribute("accountName", accountName);
        model.addAttribute("codeProduct", codeProduct);
        model.addAttribute("nameEmployees", nameEmployees);
        model.addAttribute("nameCustomer", nameCustomer);
        model.addAttribute("phoneNumberCustomer", phoneNumberCustomer);
        model.addAttribute("idEmployees", idEmployees);
        model.addAttribute("dayOrderStart", dayOrderStart);
        model.addAttribute("dayOrderEnd", dayOrderEnd);
        model.addAttribute("nameStatus", nameStatus);
        return "order/order-list";
    }
}

