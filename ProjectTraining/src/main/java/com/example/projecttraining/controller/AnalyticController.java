package com.example.projecttraining.controller;


import com.example.projecttraining.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/analytics")
public class AnalyticController {

    @Autowired
    private IOrderService iOrderService;

    @GetMapping("/list")
    private String getAllAnalytics(@RequestParam(required = false, defaultValue = "0") int pageCustomerNotBuyProduct,
                                   @RequestParam(required = false, defaultValue = "0") int pageProductBestSeller,
                                   @RequestParam(required = false, defaultValue = "0") int pageProductNoOrder,

                                   @RequestParam(required = false, defaultValue = "") String  dayOrderStart,
                                   @RequestParam(required = false, defaultValue = "") String  dayOrderEnd,
                                   Model model){
        if (dayOrderStart.isEmpty() || dayOrderStart.length() < 10  ) {
				dayOrderStart = "2000-01-01";
				model.addAttribute("dayOrderStart", "");
			}else if (dayOrderStart.length() == 10) {
				model.addAttribute("dayOrderStart", dayOrderStart);
			} else {
				dayOrderStart = "9999-01-01";
				model.addAttribute("dayOrderStart", "");
			}
			if (dayOrderEnd.isEmpty() || dayOrderEnd.length() > 10  ) {
				dayOrderEnd = "9999-01-01";
				model.addAttribute("dayOrderEnd", "");
			}else if (dayOrderEnd.length() == 10) {
				model.addAttribute("dayOrderEnd", dayOrderEnd);
			} else {
				dayOrderEnd = "2000-01-01";
				model.addAttribute("dayOrderEnd", "");
			}
        int index = 2 ;
        List<Map<String, Object>> listProductBestSeller = iOrderService.getListProductBestSeller(LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd), index, index * pageProductBestSeller);
        List<Map<String, Object>> listCustomerNotBuyProduct= iOrderService.getListCustomerNotBuyProduct(LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd), index, index * pageCustomerNotBuyProduct );
        List<Map<String, Object>> listProductNoOrder = iOrderService.getListProductNoOrder(LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd), index, index * pageProductNoOrder);

        int countListProductBestSeller = iOrderService.countListProductBestSeller(LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd));
        double totalProductBestSeller = (double) countListProductBestSeller / index;
        int totalPageProductBestSeller = (int) Math.ceil(totalProductBestSeller);

        int countCustomerNotBuyProduct = iOrderService.countCustomerNotBuyProduct(LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd));
        double totalCustomerNotBuyProduct = (double) countCustomerNotBuyProduct /index;
        int totalPageCustomerNotBuyProduct = (int) Math.ceil(totalCustomerNotBuyProduct);

        int countListProductNoOrder = iOrderService.countListProductNoOrder(LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd));
        double totalProductNoOrder = (double) countListProductNoOrder / index;
        int totalPageProductNoOrder = (int) Math.ceil(totalProductNoOrder);




        model.addAttribute("listCustomerNotBuyProduct", listCustomerNotBuyProduct);
        model.addAttribute("listProductBestSeller", listProductBestSeller);
        model.addAttribute("listProductNoOrder", listProductNoOrder);
        model.addAttribute("totalPageProductBestSeller", totalPageProductBestSeller);
        model.addAttribute("totalPageCustomerNotBuyProduct", totalPageCustomerNotBuyProduct);
        model.addAttribute("totalPageProductNoOrder", totalPageProductNoOrder);
        model.addAttribute("pageCustomerNotBuyProduct", pageCustomerNotBuyProduct);
        model.addAttribute("pageProductBestSeller", pageProductBestSeller);
        model.addAttribute("pageProductNoOrder", pageProductNoOrder);
        model.addAttribute("index", index);

        return "analytic/show";






//        double totalCustomerNotBuyProduct = (double) countCustomerNotBuyProduct / index;
//        int totalPageCustomerNotBuyProduct = (int) Math.ceil(totalCustomerNotBuyProduct);
//        model.addAttribute("listCustomerNotBuyProduct", listCustomerNotBuyProduct);
//        model.addAttribute("totalPageCustomerNotBuyProduct", totalPageCustomerNotBuyProduct);
//        model.addAttribute("page", page);
//        model.addAttribute("index", index);






//
//
//        double totalProductNoOrder = (double) countListProductNoOrder / index;
//        int totalPageProductNoOrder = (int) Math.ceil(totalProductNoOrder);
//        model.addAttribute("listProductNoOrder", listProductNoOrder);
//        model.addAttribute("totalPageProductNoOrder", totalPageProductNoOrder);
//        model.addAttribute("page", page);
//        model.addAttribute("index", index);



//List<Customer> customers = orderService.customerZeroOrder(beginDate, endDate, (pageCustomer-1)*LIMIT);
//		List<ProductBestSellerResponse> productBestSeller = orderService.productBestSeller(beginDate, endDate, (pageProductBestSeller-1)*LIMIT);
//		List<Product> products = orderService.productZeroOrder(beginDate, endDate, (pageProduct-1)*LIMIT);
//		int totalRecord = orderService.totalCustomerZeroOrder(beginDate, endDate);
//		int totalCustomerZeroOrder = totalRecord % LIMIT == 0 ? totalRecord / LIMIT : totalRecord / LIMIT + 1;
//		totalRecord = orderService.totalProductBestSeller(beginDate, endDate);
//		int totalProductBestSeller =  totalRecord % LIMIT == 0 ? totalRecord / LIMIT : totalRecord / LIMIT + 1;
//		totalRecord = orderService.totalProductZeroOrder(beginDate, endDate);
//		int totalProductZeroOrder =  totalRecord % LIMIT == 0 ? totalRecord / LIMIT : totalRecord / LIMIT + 1;
//
//		model.addAttribute("customers", customers);
//		model.addAttribute("productBestSeller", productBestSeller);
//		model.addAttribute("products", products);
//		model.addAttribute("totalCustomerZeroOrder", totalCustomerZeroOrder);
//		model.addAttribute("totalProductBestSeller", totalProductBestSeller);
//		model.addAttribute("totalProductZeroOrder", totalProductZeroOrder);
//		model.addAttribute("isAdmin", authService.isAdmin());
//    	model.addAttribute("url","report");
//    	model.addAttribute("beginDate",beginDate);
//    	model.addAttribute("endDate",endDate);
//    	model.addAttribute("pageCustomer",pageCustomer);
//    	model.addAttribute("pageProductBestSeller",pageProductBestSeller);
//    	model.addAttribute("pageProduct",pageProduct);
//		return "analytics/show";

    }






}
