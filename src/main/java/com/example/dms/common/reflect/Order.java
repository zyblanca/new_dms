package com.example.dms.common.reflect;

import java.util.Map;

/**
 * @author zhouy
 * @date 2021/9/26
 * good 09
 */
public class Order {
    private  Integer orderNum;
    private  String orderName;
    private Map<String,String> good;

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Map<String, String> getGood() {
        return good;
    }

    public void setGood(Map<String, String> good) {
        this.good = good;
    }
}
