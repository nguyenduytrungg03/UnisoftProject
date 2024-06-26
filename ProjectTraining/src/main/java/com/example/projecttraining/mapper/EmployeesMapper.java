package com.example.projecttraining.mapper;

import com.example.projecttraining.model.Employees;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeesMapper {
    List<Map<String,Object>> getAllEmployees(String accountName, String nameEmployees, String phoneNumber, int pageIndex, int pageSize);

    int countEmployees(String accountName, String nameEmployees, String phoneNumber);

    void deleteEmployees(int idEmployees);

    Map<String, Object> getEmployeesByIdEmployees(int idEmployees);

    int createEmployees(String nameEmployees, String phoneNumber, int accountId);

    Employees getEmployeesByAccountId (int idAccount);

    int updateEmployees(String nameEmployees, String phoneNumber, int versionEmployees, int idEmployees);

    int getIdAccountsByIdEmployees(int idEmployees);
}
