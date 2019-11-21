package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.*;

import com.jk.service.ExerciseService;
import com.jk.service.VenueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Security;
import java.util.*;

@Controller
@RequestMapping("exercise")
public class ExerciseController {

    @Reference
    private ExerciseService exerciseService;
    @Reference
    private VenueService venueService;




    /**
     * 查询时间所有信息
     *
     * @return
     */
    @RequestMapping("queryList")
    @ResponseBody
    public List<timeModel> queryList() {

        return exerciseService.queryList();
    }


    /**
     * 查询场馆所有信息
     *
     * @return
     */
    @RequestMapping("queryVenue")
    @ResponseBody
    public List<Venue> queryVenue() {

        return exerciseService.queryVenue();
    }

    /**
     * 跳转预约页面
     *
     * @param venueId
     * @param model
     * @return
     */
    @RequestMapping("toMakeInfo")
    public String toMakeInfo(Integer venueId, Model model) {
        Venue venue = venueService.getVenueById(venueId);




        model.addAttribute("venue", venue);

        return "Reserve";
    }


    /**
     * 订单预定
     *
     * @param userId
     * @param venueId
     * @return
     */
    @RequestMapping("makeOrder")
    @ResponseBody
    public String makeOreder(Integer userId, Integer venueId) {

        if (userId == null) {
            return "error";
        } else {
            Venue venue = venueService.queryVenueById(venueId);
            venueService.addUserMakeVenue(userId, venue);
            return "success";
        }
    }

    /**
     * 评论查询
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping("queryAppraise")
    @ResponseBody
    public HashMap<String ,Object> queryAppraise(Integer venueId,Integer page,Integer rows) {

        return exerciseService.queryAppraise(venueId,page,rows);
    }
    /**
     * 新增订单
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping("addPayment")
    @ResponseBody
    public void addPayment(OrderInfo orderInfo) {

        exerciseService.addPayment(orderInfo);


    }

    /**
     * 收藏场馆
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping("venuelike")
    @ResponseBody
    public void venuelike(Integer venueId, Integer likeId) {

        exerciseService.venuelike(venueId, likeId);
    }

    /**
     * 新增评论
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping("appadd")
    @ResponseBody
    public void appadd(UserAppraise userAppraise) {

        exerciseService.appadd(userAppraise);
    }


}
