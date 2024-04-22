package com.example.projecttraining.dto;

import com.example.projecttraining.model.Account;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EmployeesDTO implements Validator {


    private int idEmployees;
    private String nameEmployees;
    private String phoneNumber;
    private int statusDelete;
    private int versionEmployees;
    private Account account;

    public EmployeesDTO() {
    }

    public EmployeesDTO(int idEmployees, String nameEmployees, String phoneNumber, int statusDelete, int versionEmployees, Account account) {
        this.idEmployees = idEmployees;
        this.nameEmployees = nameEmployees;
        this.phoneNumber = phoneNumber;
        this.statusDelete = statusDelete;
        this.versionEmployees = versionEmployees;
        this.account = account;
    }

    public int getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(int idEmployees) {
        this.idEmployees = idEmployees;
    }

    public String getNameEmployees() {
        return nameEmployees;
    }

    public void setNameEmployees(String nameEmployees) {
        this.nameEmployees = nameEmployees;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(int statusDelete) {
        this.statusDelete = statusDelete;
    }

    public int getVersionEmployees() {
        return versionEmployees;
    }

    public void setVersionEmployees(int versionEmployees) {
        this.versionEmployees = versionEmployees;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    @Override
    public String toString() {
        return "EmployeesDTO " +
                "idEmployees " + idEmployees +
                ", nameEmployees " + nameEmployees +
                ", phoneNumber " + phoneNumber +
                ", statusDelete " + statusDelete +
                ", versionEmployees " + versionEmployees +
                ", account " + account;
    }
}
