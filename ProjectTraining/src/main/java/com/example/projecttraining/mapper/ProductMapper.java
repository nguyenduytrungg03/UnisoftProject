package com.example.projecttraining.mapper;

import com.example.projecttraining.model.Product;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
//    List<Product> getAllProduct(@Param("pageIndex") int pageIndex,
//                                @Param("pageSize") int pageSize);
    List<Map<String, Object>> getAllProduct(String codeProduct, String nameProduct, int pageIndex, int pageSize);
    
    void deleteProduct(int idProduct);
    
    Product findByIdProduct( int idProduct);

    int updateProduct(Product product);
    
    int countProduct();

    int createProduct( Product product);
    
    int exitsByCodeProductNotIdProduct(String codeProduct, int idProduct );
    
    int exitsByNameProductNotIdProduct(String nameProduct, int idProduct);
    
    int exitsByCodeProduct(String codeProduct);
    
    int exitsByNameProduct(String nameProduct);

    String getCodeByName(String nameProduct);

    String getNameByCode(String codeProduct);

    Product getProductByCodeProduct(String codeProduct);
}
