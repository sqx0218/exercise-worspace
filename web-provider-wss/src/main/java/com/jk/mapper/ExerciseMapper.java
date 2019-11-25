package com.jk.mapper;

import com.jk.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper

public interface ExerciseMapper {

    List<Venue> queryVenues();

    List<UserAppraise> queryAppraise();

    List<timeModel> queryList();

    @Update("update  t_venue set venueLike='2' where venueId=#{value}")
    void updatevuen(Integer venueId);

    @Update("update t_venue set venueLike='1' where venueId=#{value}")
    void updatevuen2(Integer venueId);

    List<UserVenue> queryUserLike(@Param("userName") String userName);

    @Insert("insert into t_order_info  (userId,venueId,orderTime,orderNum,orderPrice,orderStatus,orderInfo,orderId) \n" +
            "value(#{userId},#{venueId},#{orderTime},#{orderNum},#{orderPrice},#{orderStatus},#{orderInfo},#{orderId})")
    void addPayment(OrderInfo orderInfo);
}
