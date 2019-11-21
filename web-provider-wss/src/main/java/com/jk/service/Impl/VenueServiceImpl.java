package com.jk.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.VenueMapper;
import com.jk.model.OrderInfo;
import com.jk.model.Venue;
import com.jk.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName VenueServiceImpl
 * @Description: TODO
 * @Author 梁浩
 * @Date 2019/11/17
 * @Version V1.0
 **/
@Service
@Component
public class VenueServiceImpl implements VenueService {
    @Autowired
    private VenueMapper venueMapper;




    public List<Venue> queryFootballVenue(String typeName) {
        return venueMapper.queryFootballVenue(typeName);
    }

    @Override
    public Venue queryVenueById(Integer venueId) {
        return venueMapper.queryVenueById(venueId);
    }


    /**
     * 查询所有场馆信息
     * @return
     */
    @Override
    public List<Venue> queryVenue() {
        List<Venue> venueList = venueMapper.queryVenue();
        System.out.println(venueList.size());
        return venueList;
    }

    @Override
    public Venue getVenueById(Integer venueId) {
        return venueMapper.queryVenueById(venueId);
    }

      /**
     * 订单预定
     * @param userId
     * @param venueId
     */
    @Override
    public void addUserMakeVenue(Integer userId, Venue venue) {
        OrderInfo orderInfo = new OrderInfo();

        UUID uuid = UUID.randomUUID();
        String sdf = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String uuidNum = uuid.toString().substring(0, 5);
        uuidNum = sdf + uuidNum;
        orderInfo.setUserId(userId);

        //orderInfo.setVenueId(venue.getVenueId());
        orderInfo.setOrderNum(uuidNum);
        orderInfo.setOrderPrice(venue.getPrice());
        orderInfo.setOrderTime(new Date());
        orderInfo.setOrderStatus(1);
        //orderInfo.setOrderInfo(venue.getVenueAddress());
        System.out.println(orderInfo.getOrderNum());

        venueMapper.addOrderInfo(orderInfo);
    }




}
