package com.example.projecttraining.service.product;

import com.example.projecttraining.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProduct(int pageIndex, int pageSize);
    List<Product> searchProduct(String codeProduct, String nameProduct
//            , int pageIndex, int pageSize
    );
    void deleteProduct(int idProduct);
    int findByIdProduct(int idProduct);
    int updateProduct(String codeProduct,String nameProduct,double saleProduct,double purchasePrice);
    int countProduct();
}
