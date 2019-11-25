package com.jk.service;

import com.jk.model.*;

import java.util.HashMap;
import java.util.List;

public interface ExerciseService {


    List<timeModel> queryList();

    void addPayment(OrderInfo orderInfo);

    void venuelike(Integer venueId, Integer id);

    void appadd(UserAppraise userAppraise);

    HashMap<String, Object> queryAppraise(Integer venueId, Integer page, Integer rows);

    List<Venue> queryVenues();


    List<UserVenue> queryUserLike(String userName);
}
