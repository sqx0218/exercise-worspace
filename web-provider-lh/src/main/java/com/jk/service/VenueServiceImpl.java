package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.VenueMapper;
import com.jk.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName VenueServiceImpl
 * @Description: TODO
 * @Author 梁浩
 * @Date 2019/11/17
 * @Version V1.0
 **/
@Service
public class VenueServiceImpl implements VenueService{
    @Autowired
    private VenueMapper venueMapper;

    public List<Venue> queryFootballVenue(String typeName) {
        return venueMapper.queryFootballVenue(typeName);
    }
}
