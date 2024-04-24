package com.example.projecttraining.service.order;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IOrderService {

    List<Map<String, Object>> getAllOrder( String accountName, String nameEmployees,
                                           String codeProduct, String nameProduct,
                                           String nameCustomer, String phoneNumber,
                                           boolean isAdmin, int employeesId, LocalDate dayStart,
                                           int allocatedStatus, int orderedStatus, int pageIndex, int pageSize);



}
