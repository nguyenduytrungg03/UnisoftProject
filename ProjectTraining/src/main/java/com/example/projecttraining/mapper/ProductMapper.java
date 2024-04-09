package com.example.projecttraining.mapper;

import com.example.projecttraining.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getAllProduct(@Param("pageIndex") int pageIndex,
                                @Param("pageSize") int pageSize);
    List<Product> searchProduct(@Param("codeProduct") String codeProduct,
                                @Param("nameProduct") String nameProduct);
    void deleteProduct(@Param("idProduct") int idProduct);
    Product findByIdProduct(@Param("idProduct") int idProduct);

    int updateProduct(Product product);
    int countProduct();

    int createProduct( Product product);

}
