package com.example.projecttraining.model;



public class Account {

    private Integer accountId;

    private String accountName;

    private String password;

    private String confirmPassword;

    private Role role;
    private  boolean statusDelete ;


    public Account(int accountId, String accountName, String password, String confirmPassword, Role role, boolean statusDelete) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
        this.statusDelete = statusDelete;
    }

    public Account() {

    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(boolean statusDelete) {
        this.statusDelete = statusDelete;
    }
}
