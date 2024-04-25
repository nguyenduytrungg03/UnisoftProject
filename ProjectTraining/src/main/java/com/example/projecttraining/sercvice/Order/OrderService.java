package com.example.projecttraining.sercvice.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projecttraining.mapper.OrderMapper;


@Service
public class OrderService implements IOrderService {

	@Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Map<String, Object>> getAllOrder(String accountName, String nameEmployees,
                                                 String codeProduct, String nameProduct,
                                                 String nameCustomer, String phoneNumber,
                                                 int employeesId, LocalDate dayOrderStart, LocalDate dayOrderEnd,
                                                 int allocatedStatus, int orderedStatus,
                                                 int pageIndex, int pageSize) {
        return orderMapper.getAllOrder(accountName,nameEmployees,
                                       codeProduct, nameProduct,
                                       nameCustomer, phoneNumber,
                                       employeesId, dayOrderStart, dayOrderEnd,
                                       allocatedStatus, orderedStatus,
                                       pageIndex, pageSize);
    }

    @Override
    public int countOrder(String accountName, String nameEmployees,
                          String codeProduct, String nameProduct,
                          String nameCustomer, String phoneNumber,
                          int employeesId, LocalDate dayOrderStart, LocalDate dayOrderEnd,
                          int allocatedStatus, int orderedStatus) {
        return orderMapper.countOrder( accountName, nameEmployees,
                                       codeProduct, nameProduct,
                                       nameCustomer, phoneNumber,
                                       employeesId, dayOrderStart, dayOrderEnd,
                                       allocatedStatus, orderedStatus);
    }

}
