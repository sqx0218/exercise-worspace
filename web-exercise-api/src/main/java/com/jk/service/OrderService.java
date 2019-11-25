package com.jk.service;

import com.jk.model.OrderInfo;

import java.util.List;


public interface OrderService {


    void delOrder(Integer orderId);

    void updateStatus(Integer orderId);

    List<OrderInfo> myOrder(Integer userId);
}
