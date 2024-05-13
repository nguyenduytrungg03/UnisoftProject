package com.example.projecttraining.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OrderDTO {

    private String idOrder;

    private String codeProduct;

    private String nameProduct;

    private String nameCustomer;

    private String phoneNumberCustomer;

    private int quantity;

    private int version;


    public OrderDTO() {
    }

    public OrderDTO(String idOrder, String codeProduct, String nameProduct, String nameCustomer, String phoneNumberCustomer, int quantity, int version) {
        this.idOrder = idOrder;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.nameCustomer = nameCustomer;
        this.phoneNumberCustomer = phoneNumberCustomer;
        this.quantity = quantity;
        this.version = version;
    }


    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
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

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPhoneNumberCustomer() {
        return phoneNumberCustomer;
    }

    public void setPhoneNumberCustomer(String phoneNumberCustomer) {
        this.phoneNumberCustomer = phoneNumberCustomer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }



    public Map<String, List<String>> validate(List<OrderDTO> ordersDTO) {
        Map<String, List<String>> errorList = new TreeMap<>();
        for (int i = 0; i < ordersDTO.size(); i++) {
            List<String> fieldErrorList = new ArrayList<>();
            if (ordersDTO.get(i).getCodeProduct().isEmpty()) {
                fieldErrorList.add("codeProduct");
                fieldErrorList.add("nameProduct");
            }
            if (ordersDTO.get(i).getQuantity() <= 0) {
                fieldErrorList.add("quantity");
            }
            if (ordersDTO.get(i).getNameCustomer().isEmpty()) {
                fieldErrorList.add("nameCustomer");
                fieldErrorList.add("phoneNumberCustomer");
            }
            if (!fieldErrorList.isEmpty()) {
                errorList.put(ordersDTO.get(i).getIdOrder(), fieldErrorList);
            }

        }
        return  errorList;
    }

}
