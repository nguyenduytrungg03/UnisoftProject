package com.example.projecttraining.repository;

import com.example.projecttraining.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getAllProduct(@Param("pageIndex") int pageIndex,
                                @Param("pageSize") int pageSize);
    List<Product> searchProduct(@Param("codeProduct") String codeProduct,
                                @Param("nameProduct") String nameProduct);
    void deleteProduct(@Param("idProduct") int idProduct);
    int findByIdProduct(@Param("idProduct") int idProduct);
    int updateProduct(@Param("codeProduct")String codeProduct,
                      @Param("nameProduct")String nameProduct,
                      @Param("saleProduct")double saleProduct,
                      @Param("purchasePrice") double purchasePrice);

    int countProduct();
}
