package com.example.projecttraining.controller;


import com.example.projecttraining.dto.EmployeesDTO;
import com.example.projecttraining.model.Employees;
import com.example.projecttraining.service.employees.IEmployeesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.addAttribute("employees", new Employees());
        return "employees/employees-create";
    }


    @PostMapping("/createEmployees")
    public String createEmployees(@ModelAttribute("employeesDTO") EmployeesDTO employeesDTO,
                                  @RequestParam String accountName, @RequestParam String nameEmployees, @RequestParam String phoneNumber,
                                  @RequestParam(required = false, defaultValue = "0") int page,
                                  RedirectAttributes redirectAttributes,
                                  BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			model.addAttribute("employeesDTO", employeesDTO);
			return "employees/employees-create";
		}
        Employees employees = new Employees();
        BeanUtils.copyProperties(employeesDTO, employees);
        employees.setAccount(employeesDTO.getAccount());
        System.out.println(employees);
        int rowCreateEmployee = iEmployeesService.createEmployees(employeesDTO.getAccount(),employees);
        if (rowCreateEmployee == 1) {
            redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
            return "redirect:/employees/list?page=" + page ;
        } else {
            redirectAttributes.addFlashAttribute("message", "Thêm mới thất bại");
            return "redirect:/employees/list?page=" + page ;
        }
    }

    }



