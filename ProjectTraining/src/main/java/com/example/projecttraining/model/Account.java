package com.example.projecttraining.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


public class Account {

    private Integer accountId;

    private String accountName;

    private String password;

    private Role role;
    private  int statusDelete ;

    public Account(Integer accountId, String accountName, String password, Role role, int statusDelete) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(int statusDelete) {
        this.statusDelete = statusDelete;
    }
}
