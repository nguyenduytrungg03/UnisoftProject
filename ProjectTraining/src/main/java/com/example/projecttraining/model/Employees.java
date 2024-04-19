package com.example.projecttraining.model;


public class Employees {
    private Integer idEmployees;
    private String nameEmployees;
    private String phoneNumber;
    private int statusDelete;
    private int versionEmployees;
    private Account account;

    public Employees() {
    }

    public Employees(Integer idEmployees, String nameEmployees, String phoneNumber, int deleteStatus, int versionEmployees, Account account) {
        this.idEmployees = idEmployees;
        this.nameEmployees = nameEmployees;
        this.phoneNumber = phoneNumber;
        this.statusDelete = deleteStatus;
        this.versionEmployees = versionEmployees;
        this.account = account;
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
}
