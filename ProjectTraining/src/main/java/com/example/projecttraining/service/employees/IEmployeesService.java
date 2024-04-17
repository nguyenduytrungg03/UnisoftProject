package com.example.projecttraining.service.employees;


import com.example.projecttraining.model.Account;
import com.example.projecttraining.model.Customer;
import com.example.projecttraining.model.Employees;

import java.util.List;
import java.util.Map;

public interface IEmployeesService {
    List<Map<String,Object>> findAllEmployees(String accountName, String nameEmployees, String phoneNumber,  int pageIndex, int pageSize);

    int countEmployees(  String accountName,String nameEmployees, String phoneNumber);

    void deleteEmployees(int idEmployees);

    Employees findByIdEmployees (int idEmployees);

    int createEmployees (Employees employees);

   Employees getEmployeesByAccountId (int idAccount);


}
