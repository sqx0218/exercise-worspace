package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.OrderInfoMapper;
import com.jk.model.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * @return
     * @MethodName: myOrder
     * @Description: TODO
     * @Param: 查询订单详细信息
     * @Return: java.util.List<com.jk.model.OrderInfo>
     * @Author: 祎赟
     * @Date: 2019/11/18
     */
    @Override
    public List<OrderInfo> myOrder(Integer userId) {

        List<OrderInfo> list = orderInfoMapper.myOrder(userId);
        return list;
    }


    @Override
    public void delOrder(Integer orderId) {
        orderInfoMapper.delOrder(orderId);
    }

    @Override
    public void updateStatus(Integer orderId) {
        orderInfoMapper.updateStatus(orderId);
    }


}
