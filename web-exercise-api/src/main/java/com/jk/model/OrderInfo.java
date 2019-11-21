package com.jk.model;


import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;


public class OrderInfo implements Serializable {
    private static final long serialVersionUID = 2514118049056308458L;
    private Integer userId;

    private Integer venueId;

    private Date orderTime;

    private String orderNum;

    private Double orderPrice;

    private Integer orderStatus;

    private String orderInfo;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {

        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }
}