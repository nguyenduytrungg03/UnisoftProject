package com.example.projecttraining.model;

public class Status {
    private int idStatus;
    private String nameStatus;

    public int getIdStatus() {
        return idStatus;
    }

    public Status() {
    }

    public Status(int idStatus, String nameStatus) {
        this.idStatus = idStatus;
        this.nameStatus = nameStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }
}
