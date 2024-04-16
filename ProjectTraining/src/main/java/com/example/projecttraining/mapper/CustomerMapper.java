package com.example.projecttraining.mapper;

import com.example.projecttraining.model.Customer;
import com.example.projecttraining.model.Employees;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerMapper {

    List<Map<String, Object>> findAllCustomer(String nameCustomer, String phoneNumberCustomer, int pageIndex, int pageSize);

    int countCustomer(String nameCustomer, String phoneNumberCustomer);

    void deleteCustomer(int idCustomer);

    Customer findByIdCustomer(int idCustomer);

    int createCustomer(String nameCustomer, String phoneNumberCustomer, String addressCustomer, int idEmployees);
}
