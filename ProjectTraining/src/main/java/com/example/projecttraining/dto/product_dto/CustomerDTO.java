package com.example.projecttraining.dto.product_dto;

import com.example.projecttraining.model.Employees;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class CustomerDTO implements Validator {
    private Integer idCustomer;
    private String nameCustomer;
    private String phoneNumberCustomer;

    private String addressCustomer;

    private int versionCustomer;

    private int statusDelete;

    private Integer idEmployees;
    private String nameEmployees;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer idCustomer, String nameCustomer, String phoneNumberCustomer, String addressCustomer, int versionCustomer, int statusDelete, Integer idEmployees, String nameEmployees) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.phoneNumberCustomer = phoneNumberCustomer;
        this.addressCustomer = addressCustomer;
        this.versionCustomer = versionCustomer;
        this.statusDelete = statusDelete;
        this.idEmployees = idEmployees;
        this.nameEmployees = nameEmployees;
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

    public Integer getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(Integer idEmployees) {
        this.idEmployees = idEmployees;
    }

    public String getNameEmployees() {
        return nameEmployees;
    }

    public void setNameEmployees(String nameEmployees) {
        this.nameEmployees = nameEmployees;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "idCustomer= " + idCustomer +
                ", nameCustomer= " + nameCustomer +
                ", phoneNumberCustomer= " + phoneNumberCustomer +
                ", addressCustomer= " + addressCustomer +
                ", versionCustomer= " + versionCustomer +
                ", statusDelete= " + statusDelete +
                ", idEmployees= " + idEmployees +
                ", nameEmployees= " + nameEmployees +
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
