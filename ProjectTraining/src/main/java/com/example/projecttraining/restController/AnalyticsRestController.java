package com.example.projecttraining.restController;

import com.example.projecttraining.common.Page;
import com.example.projecttraining.dto.AnalyticsDTO;
import com.example.projecttraining.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/analytics")
public class AnalyticsRestController {

    @Autowired
    private IOrderService iOrderService;

    @GetMapping("/customernotbuyproduct")
    private AnalyticsDTO listCustomerNotBuyProduct(@RequestParam int page,
                                                   @RequestParam(required = false, defaultValue = "") String dayOrderStart,
                                                   @RequestParam(required = false, defaultValue = "") String dayOrderEnd) {
        AnalyticsDTO analyticsDTO = new AnalyticsDTO();
        try {
            int index = 1;
            if (page != 0) {
                page = page - 1;
            }
            if (dayOrderStart.isEmpty()) {
                dayOrderStart = "2000-10-10";
                analyticsDTO.setDayOrderStart("");
            } else {
                analyticsDTO.setDayOrderStart(dayOrderStart);
            }
            if (dayOrderEnd.isEmpty()) {
                dayOrderEnd = "9999-10-10";
                analyticsDTO.setDayOrderEnd("");
            } else {
                analyticsDTO.setDayOrderEnd(dayOrderEnd);
            }
            List<Map<String, Object>> listCustomerNotBuyProduct = iOrderService.getListCustomerNotBuyProduct(LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd), index, index * page);
            analyticsDTO.setCustomerList(listCustomerNotBuyProduct);
            int countListCustomerNotBuyProduct = iOrderService.countCustomerNotBuyProduct(LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd));
            double totalCustomerNotBuyProduct = (double) countListCustomerNotBuyProduct / index;
            int totalPageCustomerNotBuyProduct = (int) Math.ceil(totalCustomerNotBuyProduct);
            Map<String, Object> handlePaging = Page.handlePaging(page, totalPageCustomerNotBuyProduct);
            analyticsDTO.setStartPage((int) handlePaging.get("startPage"));
            analyticsDTO.setEndPage((int) handlePaging.get("endPage"));
            analyticsDTO.setShowThreeDotStart((Boolean) handlePaging.get("showThreeDotStart"));
            analyticsDTO.setShowThreeDotEnd((Boolean) handlePaging.get("showThreeDotEnd"));
            analyticsDTO.setPage(page);
            analyticsDTO.setTotalPage(totalPageCustomerNotBuyProduct);
            analyticsDTO.setIndex(index);
            return analyticsDTO;
        } catch (Exception e) {
            analyticsDTO.setMessageError("Lỗi !!! Vui lòng thử lại");
            analyticsDTO.setCustomerList(new ArrayList<>());
            return analyticsDTO;
        }
    }

}
