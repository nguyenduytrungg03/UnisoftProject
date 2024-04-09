package com.example.projecttraining.service.product;

import com.example.projecttraining.model.Product;
import com.example.projecttraining.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> findAllProduct(int pageIndex, int pageSize) {
        return productMapper.getAllProduct(pageIndex,pageSize);
    }

    @Override
    public List<Product> searchProduct(String codeProduct, String nameProduct
//            ,int pageIndex, int pageSize
    ) {
        return productMapper.searchProduct(codeProduct, nameProduct
//                , pageIndex, pageSize
        );
    }
    @Override
    public void deleteProduct(int idProduct) {
        productMapper.deleteProduct(idProduct);
    }

    @Override
    public Product findByIdProduct(int idProduct) {
        return productMapper.findByIdProduct(idProduct);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    public int countProduct() {
        return productMapper.countProduct();
    }

    @Override
    public int createProduct(Product product) {
        return productMapper.createProduct(product);
    }


}
