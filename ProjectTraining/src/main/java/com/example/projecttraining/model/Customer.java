package com.example.projecttraining.model;


public class Customer {
    private Integer idCustomer;
    private String nameCustomer;
    private String phoneNumberCustomer;

    private String addressCustomer;

    private int versionCustomer;

    private int statusDelete;

    private Employees employees;


    public Customer() {
    }

    public Customer(int idCustomer, String nameCustomer, String phoneNumberCustomer, String addressCustomer, int versionCustomer, int statusDelete, Employees employees) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.phoneNumberCustomer = phoneNumberCustomer;
        this.addressCustomer = addressCustomer;
        this.versionCustomer = versionCustomer;
        this.statusDelete = statusDelete;
        this.employees = employees;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPhoneNumberCustomer() {
        return phoneNumberCustomer;
    }

    public void setPhoneNumberCustomer(String phoneNumberCustomer) {
        this.phoneNumberCustomer = phoneNumberCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public int getVersionCustomer() {
        return versionCustomer;
    }

    public void setVersionCustomer(int versionCustomer) {
        this.versionCustomer = versionCustomer;
    }

    public int getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(int statusDelete) {
        this.statusDelete = statusDelete;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
