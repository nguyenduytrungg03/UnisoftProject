package com.example.projecttraining.sercvice.Order;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IOrderService {
	

	 List<Map<String, Object>> getAllOrder( String accountName, String nameEmployees,
             								String codeProduct, String nameProduct,
             								String nameCustomer, String phoneNumber,
             								int employeesId, LocalDate dayOrderStart, LocalDate dayOrderEnd,
             								int allocatedStatus, int orderedStatus, int pageIndex, int pageSize);

             int countOrder(				String accountName, String nameEmployees,
            		 						String codeProduct, String nameProduct,
            		 						String nameCustomer, String phoneNumber,
            		 						int employeesId, LocalDate dayOrderStart, LocalDate dayOrderEnd,
            		 						int allocatedStatus, int orderedStatus);
                                 

}
