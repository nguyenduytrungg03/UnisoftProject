package com.example.projecttraining.restController;

import com.example.projecttraining.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/code")
    private String getCodeProductByNameProduct(@RequestParam String nameProduct) {
        return iProductService.getCodeByName(nameProduct);
    }

    @GetMapping("/name")
    private String getNameProductByCodeProduct(@RequestParam String codeProduct) {
        return iProductService.getNameByCode(codeProduct);
    }


}
