package com.example.projecttraining.dto;


import java.util.Map;
import java.util.List;

public class AnalyticsDTO {
    private List<Map<String, Object>> customerList;
    private List<Map<String, Object>> productList;
    private int totalPage;
    private int endPage;
    private int startPage;
    private int index;
    private int page;
    private String dayOrderStart;
    private String dayOrderEnd;
    private Boolean showThreeDotStart;
    private Boolean showThreeDotEnd;

    private String messageError;

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

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
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

    public Boolean getShowThreeDotStart() {
        return showThreeDotStart;
    }

    public void setShowThreeDotStart(Boolean showThreeDotStart) {
        this.showThreeDotStart = showThreeDotStart;
    }

    public Boolean getShowThreeDotEnd() {
        return showThreeDotEnd;
    }

    public void setShowThreeDotEnd(Boolean showThreeDotEnd) {
        this.showThreeDotEnd = showThreeDotEnd;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }
}
