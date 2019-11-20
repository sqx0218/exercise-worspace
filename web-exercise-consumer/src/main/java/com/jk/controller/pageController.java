package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Venue;
import com.jk.service.ExerciseService;

import com.jk.service.VenueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName PageController
 * @Description: TODO
 * @Author 武莎莎
 * @Date 2019/11/15
 * @Version V1.0
 **/
@RequestMapping("page")
@Controller
public class PageController {


    @RequestMapping("getMap1")
    public String getMap1(){
        return "ditu1";
    }



    @RequestMapping("getMap")
    public String getMap(){
        return "ditu";
    }


    @RequestMapping("getReserve")
    public String getReserve(){
        return "Reserve";
    }




}
