package com.example.projecttraining.dto;

import org.jetbrains.annotations.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EmployeesDTO implements Validator {
    private int idEmployees;
    private String nameEmployees;
    private String phoneNumber;

    private String accountName;
    private String password;
    private String confirmPassword;

    private int versionAccount;
    private int accountId;
    private int statusDelete;
    private int versionEmployees;

    public EmployeesDTO() {
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public int getVersionAccount() {
        return versionAccount;
    }

    public void setVersionAccount(int versionAccount) {
        this.versionAccount = versionAccount;
    }


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean supports(@NotNull Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(@NotNull Object target, @NotNull Errors errors) {
        EmployeesDTO employeesDTO = (EmployeesDTO) target;
        if (employeesDTO.getAccountName().isEmpty()) {
            errors.rejectValue("accountName",null,"Tên đăng nhập không được để trống");
        }
        if (!employeesDTO.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
            errors.rejectValue("password",null,"Mật khẩu không hợp lệ, Mật khẩu phải có ít nhất một chữ in hoa, và một kí tự số. Mật khẩu phải từ 8 kí tự trở lên");
        }
        if (employeesDTO.getNameEmployees().isEmpty()) {
            errors.rejectValue("nameEmployees",null ,"Yêu cầu nhập tên nhân viên");
        }
        if (!employeesDTO.getPhoneNumber().matches("^0[\\d]{9}$")){
            errors.rejectValue("phoneNumber",null,"Yêu cầu nhập số điện thoại");
        }        if(!employeesDTO.getConfirmPassword().equals(employeesDTO.getPassword())) {
           errors.rejectValue("confirmPassword",null, "Xác nhận mật khẩu không trùng khớp.");
        }
    }

    @Override
    public @NotNull Errors validateObject(@NotNull Object target) {
        return Validator.super.validateObject(target);
    }


}
