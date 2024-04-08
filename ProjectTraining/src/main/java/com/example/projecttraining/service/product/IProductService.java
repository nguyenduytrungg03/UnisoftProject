package com.example.projecttraining.service.product;

import com.example.projecttraining.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProduct(int pageIndex, int pageSize);
    List<Product> searchProduct(String codeProduct, String nameProduct
//            , int pageIndex, int pageSize
    );
    void deleteProduct(int idProduct);
    Product findByIdProduct(int idProduct);

    int updateProduct(Product product);
    int countProduct();

    int createProduct(Product product);

}

