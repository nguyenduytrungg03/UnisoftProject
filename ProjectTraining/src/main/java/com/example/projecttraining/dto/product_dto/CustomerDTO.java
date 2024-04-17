package com.example.projecttraining.dto.product_dto;

import com.example.projecttraining.model.Employees;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerDTO implements Validator {
    private int idCustomer;
    private String nameCustomer;
    private String phoneNumberCustomer;

    private String addressCustomer;

    private int versionCustomer;

    private int statusDelete;

    private Employees employees;

    public CustomerDTO() {
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
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

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "idCustomer= " + idCustomer +
                ", nameCustomer= " + nameCustomer +
                ", phoneNumberCustomer= " + phoneNumberCustomer  +
                ", addressCustomer= " + addressCustomer +
                ", versionCustomer= " + versionCustomer +
                ", statusDelete= " + statusDelete +
                ", employees= " + employees +
                '}';
    }

    @Override
    public boolean supports(@NotNull Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(@NotNull Object target, @NotNull Errors errors) {

    }

    @Override
    public @NotNull Errors validateObject(@NotNull Object target) {
        return Validator.super.validateObject(target);
    }
}
