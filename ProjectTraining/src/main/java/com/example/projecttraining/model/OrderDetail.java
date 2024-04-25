package com.example.projecttraining.model;

import java.time.LocalDateTime;

public class OrderDetail {
	
	 private Integer idOrder;
	    private LocalDateTime dayOrderStart;
	    private LocalDateTime dayOrderAllocated;
	    private double price;
	    private int quantity;
	    private int versionOrder;
	    private String address;
	    private Product product;
	    private Customer customer;
	    private Status status;
	    private Account account;
	    private Employees employees;
	    
	    
	    
	    
		public OrderDetail() {
			super();
		}
		public Integer getIdOrder() {
			return idOrder;
		}
		public void setIdOrder(Integer idOrder) {
			this.idOrder = idOrder;
		}
		public LocalDateTime getDayOrderStart() {
			return dayOrderStart;
		}
		public void setDayOrderStart(LocalDateTime dayOrderStart) {
			this.dayOrderStart = dayOrderStart;
		}
		public LocalDateTime getDayOrderAllocated() {
			return dayOrderAllocated;
		}
		public void setDayOrderAllocated(LocalDateTime dayOrderAllocated) {
			this.dayOrderAllocated = dayOrderAllocated;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getVersionOrder() {
			return versionOrder;
		}
		public void setVersionOrder(int versionOrder) {
			this.versionOrder = versionOrder;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public Status getStatus() {
			return status;
		}
		public void setStatus(Status status) {
			this.status = status;
		}
		public Account getAccount() {
			return account;
		}
		public void setAccount(Account account) {
			this.account = account;
		}
		public Employees getEmployees() {
			return employees;
		}
		public void setEmployees(Employees employees) {
			this.employees = employees;
		}
	    

}
