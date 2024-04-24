package com.example.projecttraining.service.order;

import com.example.projecttraining.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Map<String, Object>> getAllOrder(String accountName, String nameEmployees,
                                                 String codeProduct, String nameProduct,
                                                 String nameCustomer, String phoneNumber, boolean isAdmin,
                                                 int employeesId, LocalDate dayStart, int allocatedStatus, int orderedStatus, int pageIndex, int pageSize) {
        return orderMapper.getAllOrder(accountName,nameEmployees, codeProduct,
                                       nameProduct,nameCustomer,
                                       phoneNumber,isAdmin,
                                       employeesId, dayStart,
                                       allocatedStatus,orderedStatus,pageIndex, pageSize);
    }
}
