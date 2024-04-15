package com.example.projecttraining.controller;

import com.example.projecttraining.service.employees.IEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        int index = 2;

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
    public String deleteEmployees(@RequestParam("idEmployees") int idEmployees, RedirectAttributes redirectAttributes){
        iEmployeesService.deleteEmployees(idEmployees);
        redirectAttributes.addFlashAttribute("message", "Xóa nhân viên thành công!");
        return "redirect:employees/employees/list";
    }

//    @GetMapping("/formUpdate")
//    public String getFormUpdateEmployees(@RequestParam)

}
