package com.example.projecttraining.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class AnalyticsDTO {

    private List<Map<String, Object>> customerList;

    private List<Map<String, Object>> productList;

    private int totalPage;

    private int startPage;

    private int endPage;

    private int index;

    private int page;

    private String dayOrderStart;

    private String dayOrderEnd;

    private boolean showStartEllipsis;

    private boolean showEndEllipsis;

    public AnalyticsDTO() {
    }


    public List<Map<String, Object>> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Map<String, Object>> customerList) {
        this.customerList = customerList;
    }

    public List<Map<String, Object>> getProductList() {
        return productList;
    }

    public void setProductList(List<Map<String, Object>> productList) {
        this.productList = productList;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getDayOrderStart() {
        return dayOrderStart;
    }

    public void setDayOrderStart(String dayOrderStart) {
        this.dayOrderStart = dayOrderStart;
    }

    public String getDayOrderEnd() {
        return dayOrderEnd;
    }

    public void setDayOrderEnd(String dayOrderEnd) {
        this.dayOrderEnd = dayOrderEnd;
    }

    public boolean isShowStartEllipsis() {
        return showStartEllipsis;
    }

    public void setShowStartEllipsis(boolean showStartEllipsis) {
        this.showStartEllipsis = showStartEllipsis;
    }

    public boolean isShowEndEllipsis() {
        return showEndEllipsis;
    }

    public void setShowEndEllipsis(boolean showEndEllipsis) {
        this.showEndEllipsis = showEndEllipsis;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
}
