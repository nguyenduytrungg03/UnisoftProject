package com.example.projecttraining.dto;

import org.jetbrains.annotations.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;

public class ProductDTO implements Validator {
    static final String REGEX_ID = "^HLE-[0-9]{4}$";
    static final String REGEX_NAME_PRODUCT = "^[^\\s]+(\\s+[^\\s]+)*$";
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

    @Override
    public boolean supports(@NotNull Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(@NotNull Object target, @NotNull Errors errors) {
        ProductDTO productDTO = (ProductDTO) target;
        if (productDTO.getCodeProduct() == null || "".equals(productDTO.getCodeProduct())) {
            errors.rejectValue("codeProduct", "codeProduct", "Không được để trống!");
        } else if (!productDTO.getCodeProduct().matches(REGEX_ID)) {
            errors.rejectValue("codeProduct", null, "Sai định dạng HLE-xxxx");
        }
        if (productDTO.getNameProduct() == null
                || productDTO.getNameProduct().isEmpty()) {
            errors.rejectValue("nameProduct", null, "Yêu cầu nhập tên sản phẩm!");
        }
        else if (!productDTO.getNameProduct().matches(REGEX_NAME_PRODUCT)){
            errors.rejectValue("nameProduct", null,"Không được để trống");
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
