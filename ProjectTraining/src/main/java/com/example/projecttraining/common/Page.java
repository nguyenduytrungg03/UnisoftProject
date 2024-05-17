package com.example.projecttraining.common;

import java.util.Map;
import java.util.TreeMap;

public class Page {

    public static Map<String,Object> handlePaging(int page, int totalPage){
        Map<String ,Object> result = new TreeMap<>();
        int totalPagesInView = 8 ; //Tổng số trang nên hiển thị
        int numLinksToSide= 1; // số lượng liên kết hiển thị ở 2 bên trang
        int startPage;
        int endPage;
        boolean showThreeDotStart = false;
        boolean showThreeDotEnd = false; //hiển thị dấu ...
        if(totalPage <= totalPagesInView ){
            startPage = 1;
            endPage = totalPage;
        }else {
            if (page <= totalPagesInView){
                startPage =1;
                endPage = totalPagesInView;
                showThreeDotEnd = true;
            }else if (page >= totalPage - numLinksToSide){
                startPage= totalPage - totalPagesInView +1;
                endPage = totalPage;
                showThreeDotEnd = true;
            }else {
                startPage = page - numLinksToSide;
                endPage = page + numLinksToSide;
                showThreeDotStart = true;
                showThreeDotEnd = true;
            }
        }
        result.put("startPage", startPage);
        result.put("endPage", endPage);
        result.put("showThreeDotStart", showThreeDotStart);
        result.put("showThreeDotEnd", showThreeDotEnd);
        return result;
    }




//if (totalPage <= maxVisitablePages) {
//            startPage = 1;
//            endPage = totalPage;
//        } else {
//            if (page <= maxVisitablePages - adjacentPages) {
//                startPage = 1;
//                endPage = maxVisitablePages;
//                showEndEllipsis = true;
//            } else if (page >= totalPage - adjacentPages) {
//                startPage = totalPage - maxVisitablePages + 1;
//                endPage = totalPage;
//                showStartEllipsis = true;
//            } else {
//                startPage = page - adjacentPages;
//                endPage = page + adjacentPages;
//                showStartEllipsis = true;
//                showEndEllipsis = true;
//            }
//        }


}
