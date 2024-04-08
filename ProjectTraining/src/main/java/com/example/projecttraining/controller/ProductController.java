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
                                @RequestParam(required = false, defaultValue = "0") int page,
                                Model model) {
        int index =4;
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

    @GetMapping("/formUpdate/{idProduct}")
    public String goFromUpdate(@PathVariable("idProduct") int idProduct, Model model) {
        Product product = iProductService.findByIdProduct(idProduct);
        model.addAttribute("product",product);
        System.out.println(product);
        return "/update-product";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute( "product") Product product,
                                @RequestParam(required = false, defaultValue = "0") int page,
                                RedirectAttributes redirectAttributes){
    int row = 0;

        try {
            row = iProductService.updateProduct(product);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        if (row != 1) {
            redirectAttributes.addFlashAttribute("message","Chỉnh sửa thất bại.");
            return "redirect:/product/list?page=" +page ;
        }else {
            redirectAttributes.addFlashAttribute("message","Chỉnh sửa thành công.");
            return "redirect:/product/list?page=" + page;
        }
    }


    @GetMapping("/formCreate")
    public String goFormCreate(Model model){
    model.addAttribute("product", new Product());
    return "create-product";
    }


    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute("product") Product product,
                                @RequestParam(required = false, defaultValue = "0") int page,
                                RedirectAttributes redirectAttributes, Model model){
        int result = 0;
        try {
            result = iProductService.createProduct(product);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        if(result == 0) {
            redirectAttributes.addFlashAttribute("message","Thêm mới thất bại.");
            return "redirect:/product/list?page=" + page ;
        }else {
            redirectAttributes.addFlashAttribute("message","Thêm mới thành công.");
            return "redirect:/product/list?page=" + page ;
        }
    }




}