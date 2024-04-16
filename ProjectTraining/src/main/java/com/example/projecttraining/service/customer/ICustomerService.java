package com.example.projecttraining.service.customer;

import com.example.projecttraining.model.Customer;
import com.example.projecttraining.model.Employees;

import java.util.List;
import java.util.Map;

public interface ICustomerService {


    List<Map<String, Object>> findAllCustomer(String nameCustomer, String phoneNumberCustomer, int pageIndex, int pageSize);

    int countCustomer(String nameCustomer, String phoneNumberCustomer);

    void deleteCustomer(int idCustomer);

    Customer findByIdCustomer(int idCustomer);

    int createCustomer(String nameCustomer, String phoneNumberCustomer, String addressCustomer, int idEmployees);
}
