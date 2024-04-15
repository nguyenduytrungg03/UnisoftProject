package com.example.projecttraining.mapper;

import com.example.projecttraining.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

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

}
