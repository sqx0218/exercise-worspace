package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.VenueBean;
import com.jk.model.VenueTypeBean;

import com.jk.service.EserciseService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("page")
public class ExerciseController {

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
    public List<VenueTypeBean> queryVenueType(){
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
}
