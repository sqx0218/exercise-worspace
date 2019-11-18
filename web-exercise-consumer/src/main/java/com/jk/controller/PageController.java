package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Venue;
import com.jk.service.TypeService;
import com.jk.service.VenueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName PageController
 * @Description: TODO
 * @Author 梁浩
 * @Date 2019/11/15
 * @Version V1.0
 **/
@Controller
@RequestMapping("page")
public class PageController{

    @Reference
    private TypeService typeService;

    @Reference
    private VenueService venueService;


    /*@RequestMapping("queryTypeList")
    @ResponseBody
    public List<Type> queryTypeList(){

        List<Type> list = typeService.queryTypeList();
        return  list;
    }*/

    /**
     * 场馆类型
     * 查询足球场馆
     * @param typeName
     * @return
     */
    @RequestMapping("queryFootBallVenue")
    @ResponseBody
    public List<Venue> queryFootBallVenue(String typeName){

        List<Venue> list = venueService.queryFootballVenue(typeName);

        return list;
    }

}
