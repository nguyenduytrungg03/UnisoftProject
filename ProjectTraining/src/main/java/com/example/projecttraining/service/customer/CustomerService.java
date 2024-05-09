package com.example.projecttraining.service.customer;

import com.example.projecttraining.mapper.CustomerMapper;
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
      Map<String, Object>  map = customerMapper.getCustomerByIdCustomer(idCustomer);
      Employees employees = new Employees();
      Customer customer = new Customer();
      employees.setIdEmployees((Integer) map.get("id_employees"));
      employees.setNameEmployees((String) map.get("name_employees"));
      customer.setIdCustomer((Integer) map.get("id_customer"));
      customer.setNameCustomer((String) map.get("name_customer"));
      customer.setPhoneNumberCustomer((String) map.get("phone_number_customer"));
      customer.setAddressCustomer((String) map.get("address_customer"));
      customer.setEmployees(employees);
      return customer;
    }

    @Override
    public int createCustomer(String nameCustomer, String phoneNumberCustomer, String addressCustomer, int idEmployees) {
        return customerMapper.createCustomer(nameCustomer, phoneNumberCustomer,addressCustomer,idEmployees);
    }

    @Override
    public int updateCustomer(String nameCustomer, String phoneNumberCustomer, String addressCustomer , int versionCustomer, int idCustomer) {
        return customerMapper.updateCustomer(nameCustomer, phoneNumberCustomer, addressCustomer , versionCustomer, idCustomer);
    }

    @Override
    public String getNameByPhone(String phoneNumberCustomer) {
     return customerMapper.getNameByPhone(phoneNumberCustomer);
    }

    @Override
    public String getPhoneByName(String nameCustomer) {
      return customerMapper.getPhoneByName(nameCustomer);
    }


}
