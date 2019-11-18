package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.VenueTypeBeanMapper;
import com.jk.model.VenueBean;
import com.jk.model.VenueTypeBean;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EserciseServiceImpl implements  EserciseService{
    @Autowired
    private VenueTypeBeanMapper venueTypeBeanMapper;


    @Override
    public List<VenueTypeBean> queryVenueType() {
        List<VenueTypeBean> list = venueTypeBeanMapper.queryVenueType();
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
        return list;
    }

    @Override
    public List<VenueBean> queryVenue(Integer typeId) {
        List<VenueBean> Venuelis = venueTypeBeanMapper.queryVenue(typeId);
        for (int i = 0; i < Venuelis.size(); i++) {
            System.out.println("--------------------------------"+Venuelis.get(i).toString());
        }
        return Venuelis;
    }
}
