package com.jk.service;

import com.jk.model.VenueBean;
import com.jk.model.VenueTypeBean;

import java.util.List;

public interface EserciseService {

    List<VenueTypeBean> queryVenueType();

    List<VenueBean> queryVenue(Integer typeId);

    List<VenueBean> queryVenueName(Integer zhi1,Integer zhi2);
}
