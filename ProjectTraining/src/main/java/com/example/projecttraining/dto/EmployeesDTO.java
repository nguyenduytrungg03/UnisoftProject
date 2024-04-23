package com.example.projecttraining.dto;

import com.example.projecttraining.model.Account;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EmployeesDTO implements Validator {
    private int idEmployees;
    private String nameEmployees;
    private String phoneNumber;
//    private Account account;
    private String accountName;
    private String password;
    private String confirmPassword;
    private int statusDelete;
    private int versionEmployees;

    public EmployeesDTO() {
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

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

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
//        if (employeesDTO.getAccount().getAccountName().isEmpty()) {
//            errors.rejectValue("account.username",null,"Tên đăng nhập không được để trống");
//        }
//        if (!employeesDTO.getAccount().getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
//            errors.rejectValue("account.password",null,"Mật khẩu không hợp lệ, Mật khẩu phải có ít nhất một chữ in hoa, và một kí tự số. Mật khẩu phải từ 8 kí tự trở lên");
//        }
        if (employeesDTO.getNameEmployees().isEmpty()) {
            errors.rejectValue("name",null ,"Tên nhân viên không được để trống");
        }
        if (!employeesDTO.getPhoneNumber().matches("^0[\\d]{9}$")){
            errors.rejectValue("phoneNumber",null,"Số điện thoại không được để trống");
        }
//        if(!employeesDTO.getConfirmPassword().equals(employeesDTO.getAccount().getPassword())) {
//            errors.rejectValue("confirmPassword",null, "Xác nhận mật khẩu không trùng khớp.");
//        }
    }

    @Override
    public @NotNull Errors validateObject(@NotNull Object target) {
        return Validator.super.validateObject(target);
    }


}
