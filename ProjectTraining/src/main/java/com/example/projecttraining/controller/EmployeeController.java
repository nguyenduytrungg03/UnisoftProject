package com.example.projecttraining.controller;


import com.example.projecttraining.dto.EmployeesDTO;
import com.example.projecttraining.model.Account;
import com.example.projecttraining.model.Employees;
import com.example.projecttraining.service.account.IAccountService;
import com.example.projecttraining.service.employees.IEmployeesService;

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

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private IEmployeesService iEmployeesService; 

    @Autowired
    private IAccountService iAccountService;
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
    public String getAllListEmployees(@RequestParam(required = false, defaultValue = "0") int page
                                    , @RequestParam(required = false, defaultValue = "") String accountName
                                    , @RequestParam(required = false, defaultValue = "") String nameEmployees
                                    , @RequestParam(required = false, defaultValue = "") String phoneNumber
                                    , Model model) {
        int index = 3;
        List<Map<String, Object>> employeesList = iEmployeesService.findAllEmployees(accountName,nameEmployees, phoneNumber,  index, index * page);
        int countEmployees = iEmployeesService.countEmployees(accountName,nameEmployees, phoneNumber );
        double a = (double) countEmployees / index;
        int totalPage = (int) Math.ceil(a);
        model.addAttribute("employeesList", employeesList);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        model.addAttribute("index", index);
        model.addAttribute("accountName", accountName);
        model.addAttribute("nameEmployees", nameEmployees);
        model.addAttribute("phoneNumber", phoneNumber);
        return "employees/employees-list";
    }

    @PostMapping("/delete")
    public String deleteEmployees(@RequestParam int idEmployees, RedirectAttributes redirectAttributes){
        iEmployeesService.deleteEmployees(idEmployees);
        redirectAttributes.addFlashAttribute("message", "Xóa nhân viên thành công!");
        return "redirect:/employees/list";
    }


    @GetMapping("/formCreate")
    public String goFormCreate(Model model) {
        model.addAttribute("employeesDTO", new EmployeesDTO());
        return "employees/employees-create";
    }


    @PostMapping("/createEmployees")
    public String createEmployees(@ModelAttribute("employeesDTO") EmployeesDTO employeesDTO,
                                  @RequestParam(required = false, defaultValue = "0") int page,
                                  RedirectAttributes redirectAttributes,
                                  BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			model.addAttribute("employeesDTO", employeesDTO);
			return "employees/employees-create";
		}
        Employees employees = new Employees();
        BeanUtils.copyProperties(employeesDTO, employees);
        employees.setAccount(employees.getAccount());
        int rowCreateEmployee = iEmployeesService.createEmployees(employeesDTO.getAccountName(),employeesDTO.getPassword(),employees);
        if (rowCreateEmployee == 1) {
            redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        } else {
            redirectAttributes.addFlashAttribute("message", "Thêm mới thất bại");
        }
        return "redirect:/employees/list?page=" + page ;
    }

    @GetMapping("/formUpdate/{idEmployees}")
    public String goFormUpdate(@PathVariable ("idEmployees") int idEmployees, Model model, RedirectAttributes redirectAttributes){
        Account account = getAccountLogin();
        Employees employees = iEmployeesService.getEmployeesByIdEmployees(idEmployees);
        if (employees == null) {
            redirectAttributes.addFlashAttribute("message","Không tồn tại nhân viên này.");
            return "redirect:/employees/list";
        }
        EmployeesDTO employeesDTO = new EmployeesDTO();
        BeanUtils.copyProperties(employees, employeesDTO);
        employeesDTO.setAccountName(employees.getAccount().getAccountName());
        employeesDTO.setPassword(employees.getAccount().getPassword());
        model.addAttribute("employeesDTO",employeesDTO);
        assert account != null;
        model.addAttribute("accountName",account.getAccountName());
        return "employees/employees-update";
    }



    }



