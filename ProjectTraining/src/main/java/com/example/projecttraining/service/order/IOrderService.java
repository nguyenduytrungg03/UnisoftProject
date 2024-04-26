package com.example.projecttraining.service.order;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IOrderService {
	

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
}
