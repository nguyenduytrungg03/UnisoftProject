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



//    List<Map<String,Object>> getAllEmployee(String username, String employeeName, String phoneNumber, int limit, int page);
//
//    int countTotalRow(String username, String employeeName, String phoneNumber);
//
//    Employee getEmployeeByAccountId(int accountId);
//
//    int updateStatusEmployee(int status, int version,int id);
//
//    int deleteEmployeeById (int id);
//
//    int insertEmployee(String name, String phoneNumber, int accountId);
//
//    Map<String, Object> getEmployeeById (int id);
//
//    int updateEmployee(String phoneNumber, int version, String name, int id);
}
