package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.service.ExerciseService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("page")
@Controller
public class pageController {

    @RequestMapping("getMap")
    public String getMap(){
        return "ditu";
    }


    @RequestMapping("getReserve")
    public String getReserve(){
        return "Reserve";
    }
}
