package com.example.projecttraining.model;

public class Allocation {
    private int idAllocation;
    private String codeProduct;
    private String nameProduct;
    private double quantityImport;

    public Allocation() {
    }

    public Allocation(int idAllocation, String codeProduct, String nameProduct, double quantityImport) {
        this.idAllocation = idAllocation;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.quantityImport = quantityImport;
    }

    public int getIdAllocation() {
        return idAllocation;
    }

    public void setIdAllocation(int idAllocation) {
        this.idAllocation = idAllocation;
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

    public double getQuantityImport() {
        return quantityImport;
    }

    public void setQuantityImport(double quantityImport) {
        this.quantityImport = quantityImport;
    }
}
