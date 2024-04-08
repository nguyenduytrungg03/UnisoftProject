package com.example.projecttraining.controller;

import com.example.projecttraining.model.Product;
import com.example.projecttraining.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/list")
    public String getAllListProduct(@RequestParam(required = false, defaultValue = "0") int page,
                                    Model model) {
        int index =4;
        List<Product> productList = iProductService.findAllProduct(index, index*page);
        int countProduct = iProductService.countProduct();
        double a = (double) countProduct / index ;
        int totalPage = (int) Math.ceil(a);
        model.addAttribute("productList", productList);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("page",page);
        model.addAttribute("index",index);
        return "product-list";
    }


    @GetMapping("/search")
    public String searchProduct(@RequestParam(name = "codeProduct") String codeProduct, @RequestParam(name = "nameProduct") String nameProduct,
                                Model model) {
        List<Product> productList = iProductService.searchProduct(codeProduct, nameProduct);
        model.addAttribute("productList", productList);
        return "product/list";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int idProduct,
                                RedirectAttributes redirectAttributes) {

        iProductService.deleteProduct(idProduct);
        redirectAttributes.addFlashAttribute("message", "Xóa sản phẩm thành công!");
        return "redirect:/product/list";
    }

    @GetMapping("/updateProduct/")
    public String goFromUpdate(@RequestParam int idProduct, Model model) {
        model.addAttribute("product", iProductService.findByIdProduct(idProduct));
        return "update-product";
    }

    @PostMapping("/updateProduct")
    public  String updateProduct(@RequestParam("codeProduct") String codeProduct, @RequestParam("nameProduct") String nameProduct, @RequestParam("salePrice") double salePrice, @RequestParam("purchasePrice") double purchasePrice , Model model){
        model.addAttribute("product", iProductService.updateProduct(codeProduct,nameProduct,salePrice, purchasePrice));
        return "/product-list";
    }
}