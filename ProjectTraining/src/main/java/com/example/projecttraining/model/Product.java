package com.example.projecttraining.model;

import jakarta.persistence.*;
public class Product {


    private int idProduct;


    private String codeProduct;


    private String nameProduct;


    private double salePrice;


    private double purchasePrice;


    private int inventoryNumber;


    private int versionProduct;

    private int statusDelete = 0 ;

    public Product() {
    }

    public Product(int idProduct, String codeProduct, String nameProduct, double salePrice, double purchasePrice, int inventoryNumber, int versionProduct, int statusDelete) {
        this.idProduct = idProduct;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.inventoryNumber = inventoryNumber;
        this.versionProduct = versionProduct;
        this.statusDelete = statusDelete;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public int getVersionProduct() {
        return versionProduct;
    }

    public void setVersionProduct(int versionProduct) {
        this.versionProduct = versionProduct;
    }

    public int getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(int statusDelete) {
        this.statusDelete = statusDelete;
    }
}
