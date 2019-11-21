package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
<<<<<<< HEAD
import com.jk.model.VenueBean;
import com.jk.model.VenueTypeBean;

import com.jk.service.EserciseService;

import com.sun.org.apache.bcel.internal.generic.RET;


/*import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;*/
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.jk.model.*;

import com.jk.service.ExerciseService;
import com.jk.service.VenueService;
>>>>>>> origin/master
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


  /*  @Autowired
    private SolrClient client;*/



    @Reference(retries = 3,timeout = 10000)
    // @Reference
    private EserciseService eserciseService;


    /**
     * @MethodName: toIndex
     * @Description: TODO
     * @Param: []
     * @Return: java.lang.String
     * @Author: byw
     * @Date: 2019/11/15
     **/
    @RequestMapping("toIndex")
    public  String toIndex(){
        return "Index";
    }
    @RequestMapping("toIndex2")
    public  String toIndex2(){
        return "Index2";
    }
    @RequestMapping("toIndex3")
    public  String toIndex3(){
        return "Index3";
    }
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
    public List<VenueTypeBean> queryVenueType(VenueTypeBean Vt){
        List<VenueTypeBean> VenueTypeList=eserciseService.queryVenueType();


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
    public  List<VenueBean> queryVenue(Integer typeId){
        List<VenueBean> VenueList=eserciseService.queryVenue(typeId);
        return VenueList;
    }


    @RequestMapping("queryVenueName")
    @ResponseBody
    public List<VenueBean> queryVenueName(Integer zhi1,Integer zhi2){
        System.out.println(zhi1+"-------------------------"+zhi2);

        return eserciseService.queryVenueName(zhi1,zhi2);
    }




}
