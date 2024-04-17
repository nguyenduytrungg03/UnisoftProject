package com.example.projecttraining.controller;

import com.example.projecttraining.dto.product_dto.ProductDTO;
import com.example.projecttraining.model.Account;
import com.example.projecttraining.model.Product;
import com.example.projecttraining.service.account.IAccountService;
import com.example.projecttraining.service.product.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private IAccountService iAccountService;
    private Account getAccountLogin () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String usernameLogin = authentication.getName();
            Account account  = iAccountService.findByAccountName(usernameLogin);
            return account;
        }
        return null;
    }


//    @GetMapping("/list")
//    public String getAllListProduct(@RequestParam(required = false, defaultValue = "0") int page,
//                                    Model model) {
//        int index = 4;
//        List<Product> productList = iProductService.findAllProduct(index, index * page);
//        int countProduct = iProductService.countProduct();
//        double a = (double) countProduct / index;
//        int totalPage = (int) Math.ceil(a);
//        model.addAttribute("productList", productList);
//        model.addAttribute("totalPage", totalPage);
//        model.addAttribute("page", page);
//        model.addAttribute("index", index);
//        return "product-list";
//    }


    @GetMapping("/list")
    public String getAllProduct(@RequestParam(required = false, defaultValue = "") String codeProduct,
                                @RequestParam(required = false, defaultValue = "") String nameProduct,
                                @RequestParam(required = false, defaultValue = "0") int page,
                                Model model) {
        int index = 3;
        List<Map<String, Object>> productList = iProductService.getAllProduct(codeProduct, nameProduct, index, index * page);
        int countProduct = iProductService.countProduct();
        double a = (double) countProduct / index;
        int totalPage = (int) Math.ceil(a);
        model.addAttribute("productList", productList);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        model.addAttribute("index", index);
        model.addAttribute("codeProduct", codeProduct);
        model.addAttribute("nameProduct", nameProduct);
        return "product/product-list";
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
        Account account = getAccountLogin();
        try {
            ProductDTO productDTO = new ProductDTO();
            Product product = iProductService.findByIdProduct(idProduct);
            BeanUtils.copyProperties(product, productDTO);
            model.addAttribute("productDTO", productDTO);
            model.addAttribute("accountName",account.getAccountName());
            System.out.println(product);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        return "product/product-update";
    }
    @PostMapping("/updateProduct")

    public String updateProduct(@Valid
                                @ModelAttribute("productDTO") ProductDTO productDTO,
                                @RequestParam(required = false, defaultValue = "0") int page,
                                @RequestParam(required = false, defaultValue = "") String codeProduct,
                                @RequestParam(required = false, defaultValue = "") String nameProduct,
                                RedirectAttributes redirectAttributes,
                                BindingResult bindingResult) {
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
            return "redirect:/product/list?page=" + page  + "&codeProduct=" + codeProduct + "&nameProduct=" + nameProduct;
        } else {
            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công");
            return "redirect:/product/list?page=" + page  + "&codeProduct=" + codeProduct + "&nameProduct=" + nameProduct;
        }


    }


    @GetMapping("/formCreate")
    public String goFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "product/product-create";
    }


    @PostMapping("/createProduct")
    public String createProduct(@Valid @ModelAttribute("productDTO") ProductDTO productDTO,
                                @RequestParam(required = false, defaultValue = "") String codeProduct,
                                @RequestParam(required = false, defaultValue = "") String nameProduct,
                                @RequestParam(required = false, defaultValue = "0") int page,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("productDTO", productDTO);
            return "product/product-create";
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
            return "redirect:/product/list?page=" + page + "&codeProduct=" + codeProduct + "&nameProduct=" + nameProduct;
        } else {
            redirectAttributes.addFlashAttribute("message", "Thêm mới thành công.");
            return "redirect:/product/list?page=" + page + "&codeProduct=" + codeProduct + "&nameProduct=" + nameProduct;
        }
    }


}