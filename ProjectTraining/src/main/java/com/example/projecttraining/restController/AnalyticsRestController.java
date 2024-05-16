package com.example.projecttraining.restController;

import com.example.projecttraining.common.Page;
import com.example.projecttraining.dto.AnalyticsDTO;
import com.example.projecttraining.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/analytics")
public class AnalyticsRestController {
    @Autowired
    private IOrderService iOrderService;

    @GetMapping("/customernotbuyproduct")
    private AnalyticsDTO getListCustomerNotBuyProduct(@RequestParam int page,
                                                      @RequestParam(required = false,defaultValue = "") String dayOrderStart,
                                                      @RequestParam(required = false,defaultValue = "") String dayOrderEnd){
        AnalyticsDTO analyticsDTO = new AnalyticsDTO();
        int index =3;
                if (dayOrderStart.isEmpty()) {
                    dayOrderStart = "1990-01-01";
                    analyticsDTO.setDayOrderStart("");
                }else {
                    analyticsDTO.setDayOrderStart(dayOrderStart);
                };
                if (dayOrderEnd.isEmpty()) {
                    dayOrderEnd = "9999-01-01";
                    analyticsDTO.setDayOrderEnd("");
                }else {
                    analyticsDTO.setDayOrderEnd(dayOrderEnd);
                }
                List<Map<String, Object>> listCustomerNoOrder = iOrderService.getListCustomerNotBuyProduct(LocalDate.parse(dayOrderStart),LocalDate.parse(dayOrderEnd),index, index*page);
                analyticsDTO.setCustomerList(listCustomerNoOrder);
                int countCustomerNotBuyProduct = iOrderService.countCustomerNotBuyProduct(LocalDate.parse(dayOrderStart), LocalDate.parse(dayOrderEnd));
                double totalCustomerNotBuyProduct = (double) countCustomerNotBuyProduct /index;
        int totalPageCustomerNotBuyProduct = (int) Math.ceil(totalCustomerNotBuyProduct);
        Map<String,Object> handlePaging = Page.handlePaging(page,totalPageCustomerNotBuyProduct);
        analyticsDTO.setStartPage((int) handlePaging.get("startPage"));
        analyticsDTO.setEndPage((int) handlePaging.get("endPage"));
        analyticsDTO.setShowStartEllipsis((boolean) handlePaging.get("showEndEllipsis"));
        analyticsDTO.setShowEndEllipsis((boolean) handlePaging.get("showEndEllipsis"));

        analyticsDTO.setPage(page);
        analyticsDTO.setTotalPage(totalPageCustomerNotBuyProduct);
        analyticsDTO.setIndex(index);
        return analyticsDTO;

    }
}



