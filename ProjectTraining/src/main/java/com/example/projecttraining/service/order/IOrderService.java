package com.example.projecttraining.service.order;
import com.example.projecttraining.dto.OrderDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IOrderService {

	 int insertAndUpdateOrders(int accountId, List<OrderDTO> ordersDTO);

	 List<Map<String, Object>> getAllOrder( String accountName, String nameEmployees,
             								String codeProduct, String nameProduct,
             								String nameCustomer, String phoneNumberCustomer,
             								int idEmployees, LocalDate dayOrderStart, LocalDate dayOrderEnd,
             								String nameStatus, int pageIndex, int pageSize);

     int countOrder(				String accountName, String nameEmployees,
									String codeProduct, String nameProduct,
									String nameCustomer, String phoneNumberCustomer,
									int idEmployees, LocalDate dayOrderStart, LocalDate dayOrderEnd,
									String nameStatus);



	int countCustomerNotBuyProduct (LocalDate dayOrderStart, LocalDate dayOrderEnd);

	int countListProductBestSeller(LocalDate dayOrderStart, LocalDate dayOrderEnd);

	int countListProductNoOrder(LocalDate dayOrderStart, LocalDate dayOrderEnd);

	List<Map<String,Object>> getListCustomerNotBuyProduct(LocalDate dayOrderStart, LocalDate dayOrderEnd, int pageIndex, int pageSize);

	List<Map<String, Object>> getListProductBestSeller(LocalDate dayOrderStart, LocalDate dayOrderEnd, int pageIndex, int pageSize);

	List<Map<String, Object>> getListProductNoOrder(LocalDate dayOrderStart, LocalDate dayOrderEnd, int pageIndex, int pageSize);
}
