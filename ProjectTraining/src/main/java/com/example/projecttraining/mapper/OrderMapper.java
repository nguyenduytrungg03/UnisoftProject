package com.example.projecttraining.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

	int insertOrders(int idCustomer, String address, int idEmployees, int idProduct, int idStatus, LocalDateTime dayOrderStart, double salePrice, int quantity, int idAccounts );


	int updateOrder(int idCustomer, int idProduct, int quantity, int versionOrder, double price ,int idOrder);

	List<Map<String, Object>> findByOrder(String accountName, String nameEmployees, String codeProduct,
										  String nameProduct, String nameCustomer, String phoneNumberCustomer, int idEmployees,
										  LocalDate dayOrderStart, LocalDate dayOrderEnd, String nameStatus, int pageIndex,
										  int pageSize);

	int countOrder(String accountName, String nameEmployees, String codeProduct, String nameProduct,
				   String nameCustomer, String phoneNumberCustomer, int idEmployees, LocalDate dayOrderStart,
				   LocalDate dayOrderEnd, String nameStatus);

}