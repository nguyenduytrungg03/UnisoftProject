package com.example.projecttraining.service.product;

import com.example.projecttraining.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {
//    List<Product> findAllProduct(int pageIndex, int pageSize);
    List<Map<String, Object>> getAllProduct(String codeProduct, String nameProduct, int pageIndex, int pageSize);

    void deleteProduct(int idProduct);

    Product findByIdProduct(int idProduct);

    int updateProduct(Product product);

    int countProduct();

    int createProduct(Product product);

    boolean isCodeProductExitsToUpdate(String codeProduct, int idProduct);

    boolean isNameProductExitsToUpdate(String nameProduct, int idProduct);

    boolean exitsByNameProduct(String nameProduct);

    boolean exitsByCodeProduct(String codeProduct);

    String getCodeByName(String nameProduct);

    String getNameByCode(String codeProduct);
}

