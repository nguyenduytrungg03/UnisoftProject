package com.example.projecttraining.service.product;

import com.example.projecttraining.model.Product;
import com.example.projecttraining.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Map<String,Object>> getAllProduct(String codeProduct, String nameProduct, int pageIndex, int pageSize) {
        return productMapper.getAllProduct(codeProduct, nameProduct, pageIndex, pageSize);
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
	@Override
	public boolean isCodeProductExitsToUpdate(String codeProduct, int idProduct) {
		int result = productMapper.exitsByCodeProductNotIdProduct(codeProduct, idProduct);
		return result == 0;
	}
	@Override
	public boolean exitsByNameProduct(String nameProduct) {
		int result = productMapper.exitsByNameProduct(nameProduct);
		return result == 0;
	}
	@Override
	public boolean exitsByCodeProduct(String codeProduct) {
		int result = productMapper.exitsByCodeProduct(codeProduct);
		return result == 0;
	}

	@Override
	public boolean isNameProductExitsToUpdate(String nameProduct, int idProduct) {
		int result = productMapper.exitsByNameProductNotIdProduct(nameProduct, idProduct);
		return result == 0;
	}


}
