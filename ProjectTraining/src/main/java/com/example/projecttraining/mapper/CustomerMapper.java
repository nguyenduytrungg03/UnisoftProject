package com.example.projecttraining.mapper;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerMapper {

    List<Map<String, Object>> findAllCustomer(String nameCustomer, String phoneNumberCustomer, int pageIndex, int pageSize);

    int countCustomer(String nameCustomer, String phoneNumberCustomer);

    void deleteCustomer(int idCustomer);

    Map<String, Object> getCustomerByIdCustomer(int idCustomer);

    int createCustomer(String nameCustomer, String phoneNumberCustomer, String addressCustomer, int idEmployees);

    int updateCustomer(String nameCustomer, String phoneNumberCustomer, String addressCustomer, int versionCustomer, int idCustomer);

   String getPhoneByName(String nameCustomer);

   String getNameByPhone(String phoneNumberCustomer);

   int getIdCustomerByPhoneNumberCustomer(String phoneNumberCustomer);

   String getAddressByPhoneNumberCustomer(String phoneNumberCustomer);
}
