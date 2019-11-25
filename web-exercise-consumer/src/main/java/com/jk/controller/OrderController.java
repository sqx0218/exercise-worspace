package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.OrderInfo;
import com.jk.service.OrderService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

import java.text.SimpleDateFormat;
import java.util.*;

import static java.awt.SystemColor.info;

@Controller
public class OrderController {
    @Reference
    private OrderService orderService;

    /**
     * @MethodName: findOrderById
     * @Description: TODO
     * @Param: 查询订单信息
     * @Return: com.jk.model.OrderInfo
     * @Author: 祎赟
     * @Date: 2019/11/18
     **/
    @RequestMapping("myOrder")
    @ResponseBody
    public HashMap<String, Object> myOrder(Integer userId) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<OrderInfo> list = orderService.myOrder(userId);
        map.put("rows", list);
        return map;
    }

    /**
     * @MethodName: delOrder
     * @Description: TODO
     * @Param: 删除订单
     * @Return:
     * @Author: 祎赟
     * @Date: 2019/11/19
     **/
    @RequestMapping("delOrder")
    @ResponseBody
    public void delOrder(Integer orderId) {
        orderService.delOrder(orderId);
    }

    /**
     * @MethodName: updateStatus
     * @Description: TODO
     * @Param: 修改状态
     * @Return: java.lang.String
     * @Author: 祎赟
     * @Date: 2019/11/20
     **/
    @RequestMapping("updateStatus")
    @ResponseBody
    public String updateStatus(Integer orderId) {
        orderService.updateStatus(orderId);
        return "success";
    }


}