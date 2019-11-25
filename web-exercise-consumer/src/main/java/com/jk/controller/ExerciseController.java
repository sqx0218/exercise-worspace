package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.jk.model.VenueBean;
import com.jk.model.VenueTypeBean;

import com.jk.service.EserciseService;

import com.jk.model.*;

import com.jk.service.ExerciseService;
import com.jk.service.VenueService;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

import java.util.*;

@Controller
@RequestMapping("exercise")
public class ExerciseController {

    @Reference(retries = 3, timeout = 100000)
    private ExerciseService exerciseService;
    @Reference
    private VenueService venueService;


    /**
     * 查询时间所有信息
     *
     * @return
     * @Author: wss
     */
    @RequestMapping("queryList")
    @ResponseBody
    public List<timeModel> queryList() {

        return exerciseService.queryList();
    }

    /**
     * 跳转预约页面
     *
     * @param venueId
     * @param model
     * @return
     * @Author: wss
     */
    @RequestMapping("toMakeInfo")
    public String toMakeInfo(Integer venueId, Model model, HttpSession session) {
        Venue venue = venueService.getVenueById(venueId);
        model.addAttribute("venue", venue);
        Subject subject = SecurityUtils.getSubject();
        User principal = (User) subject.getPrincipal();
        // User principal=new User();
        // principal.setUserName("夏祎赟");
        model.addAttribute("user", principal.getUserName());

        return "Reserve";
    }


    /**
     * 跳转首页
     *
     * @param
     * @param
     * @return
     * @Author: wss
     */
    @RequestMapping("toIndex2")
    public String toIndex(Model model) {
        Subject subject = SecurityUtils.getSubject();
        User principal = (User) subject.getPrincipal();
        System.out.println(principal.getUserName());
        // User principal=new User();
        // principal.setUserName("夏祎赟");
        model.addAttribute("user", principal.getUserName());
        return "Index";
    }

    /**
     * 查询场馆所有信息
     *
     * @return
     * @Author: wss
     */
    @RequestMapping("queryVenues")
    @ResponseBody
    public List<Venue> queryVenues() {

        return exerciseService.queryVenues();
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
     * @Author: wss
     */
    @RequestMapping("queryAppraise")
    @ResponseBody
    public HashMap<String, Object> queryAppraise(Integer venueId, Integer page, Integer rows) {

        return exerciseService.queryAppraise(venueId, page, rows);
    }

    /**
     * 新增订单
     *
     * @param
     * @param
     * @return
     * @Author: wss
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
     * @Author: wss
     */
    @RequestMapping("venuelike")
    @ResponseBody
    public void venuelike(Integer venueId, Integer likeId) {

        exerciseService.venuelike(venueId, likeId);
    }

    /**
     * 跳转收藏场馆
     *
     * @param
     * @param
     * @return
     * @Author: wss
     */
    @RequestMapping("UserVenueLike")

    public String UserVenueLike(String venueLike, Model model, HttpSession session) {
        model.addAttribute("venueLike", venueLike);

        return "UserLike";
    }


    /**
     * 查询收藏所有信息
     *
     * @return
     * @Author: wss
     */
    @RequestMapping("queryUserLike")
    @ResponseBody
    public List<UserVenue> queryUserLike() {
        Subject subject = SecurityUtils.getSubject();
        User principal = (User) subject.getPrincipal();
        return exerciseService.queryUserLike(principal.getUserName());
    }


    @RequestMapping("toOrder")
    public String toOrder(Model model) {
        Subject subject = SecurityUtils.getSubject();
        User principal = (User) subject.getPrincipal();
        model.addAttribute("user", principal.getUserId());
        return "order";
    }

    /**
     * 新增评论
     *
     * @param
     * @param
     * @return
     * @Author: wss
     */
    @RequestMapping("appadd")
    @ResponseBody
    public void appadd(UserAppraise userAppraise) {

        exerciseService.appadd(userAppraise);
    }

    @Reference(retries = 3, timeout = 10000)
    // @Reference
    private EserciseService eserciseService;


    /**
     * @MethodName: queryVenueType  查询运动
     * @Description: TODO
     * @Param: []
     * @Return: java.util.List<com.jk.model.VenueTypeBean>
     * @Author: byw
     * @Date: 2019/11/17
     **/

    @RequestMapping("queryVenueType")
    @ResponseBody
    public List<VenueTypeBean> queryVenueType(VenueTypeBean Vt) {
        List<VenueTypeBean> VenueTypeList = eserciseService.queryVenueType();


        return VenueTypeList;
    }


    /**
     * @MethodName: 查询场馆
     * @Description: TODO
     * @Param:
     * @Return:
     * @Author: byw
     * @Date: 2019/11/17
     **/


    @RequestMapping("queryVenue")
    @ResponseBody
    public List<VenueBean> queryVenue(Integer typeId) {
        List<VenueBean> VenueList = eserciseService.queryVenue(typeId);
        return VenueList;
    }


    @RequestMapping("queryVenueName")
    @ResponseBody
    public List<VenueBean> queryVenueName(Integer zhi1, Integer zhi2) {

        return eserciseService.queryVenueName(zhi1, zhi2);
    }


}
