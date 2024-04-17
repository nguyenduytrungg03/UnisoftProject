package com.example.projecttraining.service.customer;

import com.example.projecttraining.mapper.CustomerMapper;
import com.example.projecttraining.mapper.EmployeesMapper;
import com.example.projecttraining.model.Customer;
import com.example.projecttraining.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
@Controller
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private EmployeesMapper employeesMapper;

    @Override
    public List<Map<String, Object>> findAllCustomer(String nameCustomer, String phoneNumberCustomer, int pageIndex, int pageSize) {
        return customerMapper.findAllCustomer(nameCustomer, phoneNumberCustomer, pageIndex,pageSize);
    }

    @Override
    public int countCustomer(String nameCustomer, String phoneNumberCustomer) {
        return customerMapper.countCustomer(nameCustomer, phoneNumberCustomer);
    }

    @Override
    public void deleteCustomer(int idCustomer) {
        customerMapper.deleteCustomer(idCustomer);
    }

    @Override
    public Customer findByIdCustomer(int idCustomer ) {
        return customerMapper.findByIdCustomer(idCustomer);
    }

    @Override
    public int createCustomer(String nameCustomer, String phoneNumberCustomer, String addressCustomer, int idEmployees) {
        return customerMapper.createCustomer(nameCustomer, phoneNumberCustomer,addressCustomer,idEmployees);
    }

    @Override
    public int updateCustomer(String nameCustomer, String phoneNumberCustomer, String addressCustomer, int idEmployees, int versionCustomer, int idCustomer) {
        return customerMapper.updateCustomer(nameCustomer, phoneNumberCustomer, addressCustomer, idEmployees, versionCustomer, idCustomer);
    }


}
