package com.example.projecttraining.service.employees;

import com.example.projecttraining.dto.product_dto.EmployeesDTO;
import com.example.projecttraining.mapper.AccountMapper;
import com.example.projecttraining.mapper.EmployeesMapper;
import com.example.projecttraining.model.Account;
import com.example.projecttraining.model.Employees;
import com.example.projecttraining.model.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeesService implements IEmployeesService{

    @Autowired
    private EmployeesMapper employeesMapper;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AccountMapper accountMapper;
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

    @Override
    public int createEmployees( Employees employees) {
        EmployeesDTO employeesDTO = new EmployeesDTO();
        Role role = new Role(2,"ROLE_EMPLOYEES");
        Account account = new Account();
        account.setRole(role);
        Account savedAccount = accountMapper.createAccount(account);
        BeanUtils.copyProperties(employeesDTO, employees);
        employees.setAccount(savedAccount);
        return employeesMapper.createEmployees(employees);
    }

    @Override
    public Employees getEmployeesByAccountId(int idAccount) {
        return employeesMapper.getEmployeesByAccountId(idAccount);
    }
}
