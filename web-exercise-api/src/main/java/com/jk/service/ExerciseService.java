package com.jk.service;

import com.jk.model.OrderInfo;
import com.jk.model.UserAppraise;
import com.jk.model.Venue;
import com.jk.model.timeModel;

import java.util.HashMap;
import java.util.List;

public interface ExerciseService {
    List<Venue> queryVenue();



    List<timeModel> queryList();

    void addPayment(OrderInfo orderInfo);

    void venuelike(Integer venueId, Integer id);

    void appadd(UserAppraise userAppraise);

    HashMap<String ,Object> queryAppraise(Integer venueId, Integer page, Integer rows);
}
