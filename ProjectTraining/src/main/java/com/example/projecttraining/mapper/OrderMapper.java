package com.example.projecttraining.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    List<Map<String, Object>> getAllOrder(String accountName, String nameEmployees,
                                          String codeProduct,String nameProduct,
                                          String nameCustomer, String phoneNumber,
                                          boolean isAdmin, int employeesId, LocalDate dayStart,
                                          int statusAllocation,int statusBooking,
                                          int pageIndex, int pageSize);

    int countOrder();


}
