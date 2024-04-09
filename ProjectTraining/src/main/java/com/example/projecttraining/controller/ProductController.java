package com.example.projecttraining.controller;

import com.example.projecttraining.dto.product_dto.ProductDTO;
import com.example.projecttraining.model.Product;
import com.example.projecttraining.service.product.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;


    @GetMapping("/list")
    public String getAllListProduct(@RequestParam(required = false, defaultValue = "0") int page,
                                    Model model) {
        int index = 4;
        List<Product> productList = iProductService.findAllProduct(index, index * page);
        int countProduct = iProductService.countProduct();
        double a = (double) countProduct / index;
        int totalPage = (int) Math.ceil(a);
        model.addAttribute("productList", productList);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        model.addAttribute("index", index);
        return "product-list";
    }


    @GetMapping("/search")
    public String searchProduct(@RequestParam(name = "codeProduct") String codeProduct, @RequestParam(name = "nameProduct") String nameProduct,
                                @RequestParam(required = false, defaultValue = "0") int page,
                                Model model) {
        int index = 4;
        List<Product> productList = iProductService.findAllProduct(index, index * page);
        int countProduct = iProductService.countProduct();
        double a = (double) countProduct / index;
        int totalPage = (int) Math.ceil(a);
        model.addAttribute("productList", productList);
        model.addAttribute("codeProduct", codeProduct);
        model.addAttribute("nameProduct", nameProduct);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        model.addAttribute("index", index);
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
    public String goFromUpdate(@ModelAttribute("product") Product product,@PathVariable("idProduct") int idProduct, Model model) {
        try {
          product = iProductService.findByIdProduct(idProduct);
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(product, productDTO);
            model.addAttribute("productDTO", productDTO);
            System.out.println(product);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        return "/update-product";
    }

    @PostMapping("/updateProduct/{idProduct}")
    public String updateProduct(@Valid
                                @ModelAttribute("productDTO") ProductDTO productDTO,
                                @RequestParam(required = false, defaultValue = "0") int page,
                                @PathVariable("idProduct") int idProduct ,
                                RedirectAttributes redirectAttributes,
                                BindingResult bindingResult, Model model) {
        productDTO.setIdProduct(idProduct);
        new ProductDTO().validate(productDTO, bindingResult);

        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        int result = 0;
        try {
            result = iProductService.updateProduct(product);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        if (result != 1) {
            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thất bại");
            return "redirect:/product/list?page=" + page;
        } else {
            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công");
            return "redirect:/product/list?page=" + page;
        }


    }


    @GetMapping("/formCreate")
    public String goFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create-product";
    }


    @PostMapping("/createProduct")
    public String createProduct(@Valid @ModelAttribute("productDTO") ProductDTO productDTO,
                                @RequestParam(required = false, defaultValue = "0") int page,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasFieldErrors()) {
            model.addAttribute("productDTO",productDTO);
            return "create-product";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        int result = 0;
        try {
            result = iProductService.createProduct(product);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        if (result == 0) {
            redirectAttributes.addFlashAttribute("message", "Thêm mới thất bại.");
            return "redirect:/product/list?page=" + page;
        } else {
            redirectAttributes.addFlashAttribute("message", "Thêm mới thành công.");
            return "redirect:/product/list?page=" + page;
        }
    }


}