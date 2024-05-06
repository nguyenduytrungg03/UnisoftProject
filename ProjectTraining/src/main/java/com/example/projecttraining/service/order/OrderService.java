package com.example.projecttraining.service.order;

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

                                                 String nameCustomer, String phoneNumberCustomer,
                                                 int idEmployees, LocalDate dayOrderStart, LocalDate dayOrderEnd,
                                                 String nameStatus,
                                                 int pageIndex, int pageSize) {
        return orderMapper.findByOrder(accountName,nameEmployees,
                                       codeProduct, nameProduct,
                                       nameCustomer, phoneNumberCustomer,
                                       idEmployees, dayOrderStart, dayOrderEnd,
                                       nameStatus,
                                       pageIndex, pageSize);
    }

    @Override
    public int countOrder(String accountName, String nameEmployees,
                          String codeProduct, String nameProduct,

                          String nameCustomer, String phoneNumberCustomer,
                          int idEmployees, LocalDate dayOrderStart, LocalDate dayOrderEnd,
                          String nameStatus) {
        return orderMapper.countOrder( accountName, nameEmployees,
                                       codeProduct, nameProduct,

                                       nameCustomer, phoneNumberCustomer,
                                       idEmployees, dayOrderStart, dayOrderEnd,
                                       nameStatus);
    }

}
