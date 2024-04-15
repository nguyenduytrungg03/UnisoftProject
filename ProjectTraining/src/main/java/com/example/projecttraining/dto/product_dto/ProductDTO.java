package com.example.projecttraining.dto.product_dto;

import org.jetbrains.annotations.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;

public class ProductDTO implements Validator {
    static final String REGEX_ID = "^HEL-[0-9]{4}$";
    private int idProduct;
    @Pattern(regexp = REGEX_ID, message = "Wrong format HEL-xxxx")
    private String codeProduct;

    private String nameProduct;


    private double salePrice;


    private double purchasePrice;


    private int inventoryNumber;

    public ProductDTO() {

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



    public ProductDTO(int idProduct, String codeProduct, String nameProduct, double salePrice, double purchasePrice, int inventoryNumber) {
        this.idProduct = idProduct;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.inventoryNumber = inventoryNumber;

    }

    @Override
    public String toString() {
        return "ProductDTO [" +
                "idProduct=" + idProduct +
                ", codeProduct='" + codeProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", salePrice=" + salePrice +
                ", purchasePrice=" + purchasePrice +
                ", inventoryNumber=" + inventoryNumber +']';
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(@NotNull Object target, @NotNull Errors errors) {
        ProductDTO productDTO = (ProductDTO) target;
        if (productDTO.getCodeProduct() == null || "".equals(productDTO.getCodeProduct())) {
            errors.rejectValue("codeProduct", "codeProduct", "Required!");
        } else if (!productDTO.getCodeProduct().matches(REGEX_ID)) {
            errors.rejectValue("codeProduct", "code.format", "Wrong format HEL-xxxx");
        }
        if (productDTO.getNameProduct() == null
                || "".equals(productDTO.getNameProduct())) {
            errors.rejectValue("nameProduct", "nameProduct", "Yêu cầu nhập tên sản phẩm!");
        }
        if(productDTO.getSalePrice() <= 0){
            errors.rejectValue("salePrice","salePrice","Giá mua vào không hợp lệ");
        }if(productDTO.getPurchasePrice() <= 0){
            errors.rejectValue("purchasePrice","purchasePrice","Giá bán ra không hợp lệ");
        }if(productDTO.getInventoryNumber() < 0){
            errors.rejectValue("inventoryNumber","inventoryNumber","Số lượng tồn kho không hợp lệ");
        }

    }
}
