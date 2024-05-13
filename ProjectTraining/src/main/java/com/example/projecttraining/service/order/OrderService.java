package com.example.projecttraining.service.order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.example.projecttraining.dto.OrderDTO;
import com.example.projecttraining.model.Employees;
import com.example.projecttraining.model.Product;
import com.example.projecttraining.service.customer.ICustomerService;
import com.example.projecttraining.service.employees.IEmployeesService;
import com.example.projecttraining.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projecttraining.mapper.OrderMapper;


@Service
public class OrderService implements IOrderService {


    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IEmployeesService iEmployeeService;

    @Override
    public int insertAndUpdateOrders(int accountId, List<OrderDTO> orderDTO) {
        int count= 0;
        System.out.println("orderDTO: " +orderDTO);
        for(OrderDTO dto : orderDTO){
            System.out.println("dto:"+dto.getCodeProduct() );
            if (dto.getIdOrder().matches("^\\d+$")){
                int orderId = Integer.parseInt(dto.getIdOrder());
                Product product = iProductService.getProductByCodeProduct(dto.getCodeProduct());
                int customerId = iCustomerService.getIdCustomerByPhoneNumberCustomer(dto.getPhoneNumberCustomer());
                int quantity = dto.getQuantity();
                int updateOrders = orderMapper.updateOrder(customerId,product.getIdProduct(),quantity,dto.getVersion(),product.getSalePrice(),orderId);
                if (updateOrders != 1){
                    throw new RuntimeException("Không cap nhat được đơn hàng");
                }else {
                    count += 1;
                }
            }else {
                int customerId = iCustomerService.getIdCustomerByPhoneNumberCustomer(dto.getPhoneNumberCustomer());
                String address = iCustomerService.getAddressCustomerByPhoneNumberCustomer(dto.getPhoneNumberCustomer());
                Employees employees = iEmployeeService.getEmployeesByAccountId(accountId);
                Product product = iProductService.getProductByCodeProduct(dto.getCodeProduct());
                LocalDateTime dayOrderStart = LocalDateTime.now();
                int statusId = 1;
                int idAccount = iEmployeeService.getAccountIdByIdEmployees(employees.getIdEmployees());
                int insertOrders = orderMapper.insertOrders(customerId, address, employees.getIdEmployees(),product.getIdProduct(),statusId, dayOrderStart, product.getSalePrice(), dto.getQuantity(), idAccount);
                if (insertOrders != 1) {
                    throw new RuntimeException("Không thêm được đơn hàng");
                }else {
                    count +=1;
                }
            }
        }
        return count ;
    };


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
