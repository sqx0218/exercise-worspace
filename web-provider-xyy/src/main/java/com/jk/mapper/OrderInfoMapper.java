package com.jk.mapper;

import com.jk.model.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderInfoMapper {


    List<OrderInfo> myOrder(@Param("userId") Integer userId);

    void delOrder(@Param("orderId") Integer orderId);

    void updateStatus(Integer orderId);
}