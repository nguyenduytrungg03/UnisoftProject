package com.example.projecttraining.service.employees;

import com.example.projecttraining.mapper.EmployeesMapper;
import com.example.projecttraining.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeesService implements IEmployeesService{

    @Autowired
    private EmployeesMapper employeesMapper;


    @Override
    public List<Map<String, Object>> findAllEmployees( String accountName,String nameEmployees, String phoneNumber,  int pageIndex, int pageSize) {
        return employeesMapper.getAllEmployees(accountName, nameEmployees, phoneNumber, pageIndex, pageSize);
    }


    @Override
    public int countEmployees( String accountName, String nameEmployees, String phoneNumber) {
        return employeesMapper.countEmployees(accountName, nameEmployees, phoneNumber);
    }

    @Override
    public void deleteEmployees(int idEmployees) {
        employeesMapper.deleteEmployees(idEmployees);
    }

    @Override
    public Employees findByIdEmployees(int idEmployees) {
        return employeesMapper.findByIdEmployees(idEmployees);
    }
}
