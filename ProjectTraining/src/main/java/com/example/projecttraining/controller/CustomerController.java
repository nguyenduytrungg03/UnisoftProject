package com.example.projecttraining.controller;

import com.example.projecttraining.dto.CustomerDTO;
import com.example.projecttraining.model.Account;
import com.example.projecttraining.model.Customer;
import com.example.projecttraining.model.Employees;
import com.example.projecttraining.service.account.IAccountService;
import com.example.projecttraining.service.customer.ICustomerService;
import com.example.projecttraining.service.employees.IEmployeesService;
import com.example.projecttraining.service.security.UserDetailImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private ICustomerService iCustomerService;

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
    public String getAllList(@RequestParam(required = false, defaultValue = "0") int page
            , @RequestParam(required = false, defaultValue = "") String nameCustomer
            , @RequestParam(required = false, defaultValue = "") String phoneNumberCustomer
            , Model model) {
        int index = 3;

        List<Map<String, Object>> customerList = iCustomerService.findAllCustomer(nameCustomer, phoneNumberCustomer, index, index * page);
        int countCustomer = iCustomerService.countCustomer(nameCustomer, phoneNumberCustomer);
        double a = (double) countCustomer / index;
        int totalPage = (int) Math.ceil(a);
        model.addAttribute("customerList", customerList);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        model.addAttribute("index", index);
        model.addAttribute("nameCustomer", nameCustomer);
        model.addAttribute("phoneNumberCustomer", phoneNumberCustomer);
        return "customer/show";
    }

    @PostMapping("/destroy")
    public String delete(@RequestParam int idCustomer, RedirectAttributes redirectAttributes) {
        iCustomerService.deleteCustomer(idCustomer);
        redirectAttributes.addFlashAttribute("message", "Xóa khách hàng thành công!");
        return "redirect:/customer/list";
    }

    @GetMapping("/create")
    public String goFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/store")
    public String create(@ModelAttribute("customer") Customer customer,
                                 @RequestParam(required = false, defaultValue = "") String nameCustomer,
                                 @RequestParam(required = false, defaultValue = "") String phoneNumberCustomer,
                                 @RequestParam(required = false, defaultValue = "") String addressCustomer,
                                 @RequestParam(required = false, defaultValue = "0") int page,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customer", customer);
            return "customer/create";
        }
        UserDetailImpl userDetails = (UserDetailImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int result = 0;
        try {
            result = iCustomerService.createCustomer(customer.getNameCustomer(), customer.getPhoneNumberCustomer(), customer.getAddressCustomer(), userDetails.getAccountId() - 1);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        if (result == 0) {
            redirectAttributes.addFlashAttribute("message", "Thêm mới thất bại.");           
        } else {
            redirectAttributes.addFlashAttribute("message", "Thêm mới thành công.");
        }
        return "redirect:/customer/list?page=" + page;
    }

    @GetMapping("/edit/{idCustomer}")
    public String goFormUpdate(@PathVariable("idCustomer") Integer idCustomer, Model model, RedirectAttributes redirectAttributes) {
        Account accountLogin = getAccountLogin();
        assert accountLogin != null;
        Customer customer = iCustomerService.findByIdCustomer(idCustomer);
        Employees employees = iEmployeesService.getEmployeesByAccountId(accountLogin.getAccountId());
        System.out.println(customer);
        if (customer == null) {
            redirectAttributes.addFlashAttribute("message", "Không có đối tượng này");
            return "redirect:/customer/list";
        }
        if (employees != null) {
            if ((customer.getEmployees().getIdEmployees() != employees.getIdEmployees()) && !accountLogin.getRole().getNameRole().equals("ROLE_EMPLOYEES")) {
                redirectAttributes.addFlashAttribute("message", "Bạn không có quyền cập nhật đối tượng này");
                return "redirect:/customer/list";
            } else {
                CustomerDTO customerDTO = new CustomerDTO();
                BeanUtils.copyProperties(customer, customerDTO);
                model.addAttribute("customerDTO", customerDTO);
                model.addAttribute("accountName", accountLogin.getAccountName());
            }
        }
        return "customer/update";
    }


    @PostMapping("/update")
    public String update(@Valid
                                 @ModelAttribute("customerDTO") CustomerDTO customerDTO,
                                 @RequestParam(required = false, defaultValue = "0") int page,
                                 @RequestParam(required = false, defaultValue = "") String nameCustomer,
                                 @RequestParam(required = false, defaultValue = "") String phoneNumberCustomer,
                                 @RequestParam(required = false, defaultValue = "") String addressCustomer,
                                 RedirectAttributes redirectAttributes,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerDTO", customerDTO);
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        int result = 0;
        try {
            result = iCustomerService.updateCustomer(customer.getNameCustomer(), customer.getPhoneNumberCustomer(), customer.getAddressCustomer(), customer.getVersionCustomer(), customer.getIdCustomer());
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        if (result == 0) {
            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thất bại");
           
        } else {
            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công");
//            return "redirect:/customer/list?page=" + page + "&nameCustomer=" + nameCustomer + "&phoneNumberCustomer=" + phoneNumberCustomer + "&addressCustomer" + addressCustomer;
        }
        return "redirect:/customer/list" ;
    }
}
