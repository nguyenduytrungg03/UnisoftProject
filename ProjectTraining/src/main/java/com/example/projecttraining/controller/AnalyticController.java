package com.example.projecttraining.controller;


import com.example.projecttraining.common.Page;
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
				dayOrderEnd = "9999-01-01";
				model.addAttribute("dayOrderEnd", "");
			}
            int index = 1 ;
        List<Map<String, Object>> listCustomerNotBuyProduct= iOrderService.getListCustomerNotBuyProduct(LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd), index, index * pageCustomerNotBuyProduct );
        List<Map<String, Object>> listProductBestSeller = iOrderService.getListProductBestSeller(LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd), index, index * pageProductBestSeller);
        List<Map<String, Object>> listProductNoOrder = iOrderService.getListProductNoOrder(LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd), index, index * pageProductNoOrder);


        int countCustomerNotBuyProduct = iOrderService.countCustomerNotBuyProduct(LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd));
        double totalCustomerNotBuyProduct = (double) countCustomerNotBuyProduct /index;
        int totalPageCustomerNotBuyProduct = (int) Math.ceil(totalCustomerNotBuyProduct);

        Map<String,Object> pagination = Page.handlePaging(pageCustomerNotBuyProduct,totalPageCustomerNotBuyProduct);
        int startPage = (int) pagination.get("startPage");
        int endPage = (int) pagination.get("endPage");
        boolean showThreeDotStart = (boolean) pagination.get("showThreeDotStart");
        boolean showThreeDotEnd = (boolean) pagination.get("showThreeDotEnd");
        model.addAttribute("listCustomerNotBuyProduct", listCustomerNotBuyProduct);
        model.addAttribute("totalPageCustomerNotBuyProduct", totalPageCustomerNotBuyProduct);
        model.addAttribute("pageCustomerNotBuyProduct", pageCustomerNotBuyProduct);
        model.addAttribute("index", index);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("showThreeDotStart", showThreeDotStart);
        model.addAttribute("showThreeDotEnd", showThreeDotEnd);


        int countListProductBestSeller = iOrderService.countListProductBestSeller(LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd));
        double totalProductBestSeller = (double) countListProductBestSeller / index;
        int totalPageProductBestSeller = (int) Math.ceil(totalProductBestSeller);

        Map<String,Object> paginationProductBestSeller = Page.handlePaging(pageProductBestSeller,totalPageProductBestSeller);
        int startPageProductBestSeller = (int) paginationProductBestSeller.get("startPageProductBestSeller");
        int endPageProductBestSeller = (int) paginationProductBestSeller.get("endPageProductBestSeller");
        boolean showThreeDotStartProductBestSeller = (boolean) paginationProductBestSeller.get("showThreeDotStartProductBestSeller");
        boolean showThreeDotEndProductBestSeller = (boolean) paginationProductBestSeller.get("showThreeDotEndPageProductBestSeller");
        model.addAttribute("listProductBestSeller", listProductBestSeller);
        model.addAttribute("totalPageProductBestSeller", totalPageProductBestSeller);
        model.addAttribute("pageProductBestSeller", pageProductBestSeller);
        model.addAttribute("startPageProductBestSeller",startPageProductBestSeller);
        model.addAttribute("endPageProductBestSeller",endPageProductBestSeller);
        model.addAttribute("showThreeDotStartProductBestSeller", showThreeDotStartProductBestSeller);
        model.addAttribute("showThreeDotEndProductBestSeller", showThreeDotEndProductBestSeller);



        int countListProductNoOrder = iOrderService.countListProductNoOrder(LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd));
        double totalProductNoOrder = (double) countListProductNoOrder / index;
        int totalPageProductNoOrder = (int) Math.ceil(totalProductNoOrder);

        Map<String,Object> paginationProductNoOrder = Page.handlePaging(pageProductNoOrder,totalPageProductNoOrder);
        int startPageProductNoOrder = (int) paginationProductNoOrder.get("startPageProductNoOrder");
        int endPageProductNoOrder = (int) paginationProductNoOrder.get("endPageProductNoOrder");
        boolean showThreeDotStartProductNoOrder = (boolean) paginationProductNoOrder.get("showThreeDotStartProductNoOrder");
        boolean showThreeDotEndProductNoOrder = (boolean) paginationProductNoOrder.get("showThreeDotEndProductNoOrder");
        model.addAttribute("listProductNoOrder", listProductNoOrder);
        model.addAttribute("totalPageProductNoOrder", totalPageProductNoOrder);
        model.addAttribute("pageProductNoOrder", pageProductNoOrder);
        model.addAttribute("startPageProductNoOrder",startPageProductNoOrder);
        model.addAttribute("endPageProductNoOrder",endPageProductNoOrder);
        model.addAttribute("showThreeDotStartProductNoOrder", showThreeDotStartProductNoOrder);
        model.addAttribute("showThreeDotEndProductNoOrder", showThreeDotEndProductNoOrder);


        return "analytic/show";
    }
}
