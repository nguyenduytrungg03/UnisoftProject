package com.example.projecttraining.model;


public class Role {

    private int idRole;
    private String nameRole;

    public Role(int idRole, String nameRole) {
        this.idRole = idRole;
        this.nameRole = nameRole;
    }

    public Role() {
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public String toString() {
        return "Role [" +
                "idRole: " + idRole +
                ", nameRole" + nameRole + ']';
    }
}
