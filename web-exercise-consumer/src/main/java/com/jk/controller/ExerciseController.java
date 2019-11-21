package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("page")
public class ExerciseController {


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






    /*@RequestMapping("queryVenueName")
    @ResponseBody
    public Map<String,Object>queryVenueName(VenueBean venue){
        Map<String,Object> map1 = new HashMap<>();
        try {
            SolrQuery solrQuery = new SolrQuery();
            if(venue.getVenueName()!=null && !"".equals(venue.getVenueName())){
                solrQuery.set("q", venue.getVenueName());
            }else{
                solrQuery.set("q", "*:*");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }*/



  /*@RequestMapping("queryVenueName")
    @ResponseBody
    public Map<String, Object> queryVenueName(VenueBean venue){


        //返回到前台
        Map<String, Object> map1=new HashMap<>();

        try {
            //存放所有的查询条件
            SolrQuery params = new SolrQuery();

            //查询条件, 这里的 q 对应 下面图片标红的地方
            if(venue.getVenueName()!=null && !"".equals(venue.getVenueName())){
                params.set("q", venue.getVenueName());
            }else {
                params.set("q", "*:*");
            }

            //过滤条件
            // params.set("fq", "carPrice:["+car.get+" TO "++"]");

            //排序
            //params.addSort("carPrice", SolrQuery.ORDER.desc);

            //分页
            *//*if(page==null){
                params.setStart(0);
            }else {
                params.setStart((page-1)*rows);
            }
            if(rows==null){
                params.setRows(5);
            }else {
                params.setRows(rows);
            }
*//*

            //默认域
            params.set("df", "venueName");

            //只查询指定域
            //params.set("fl", "id,product_title,product_price");

            //高亮
            //打开开关
           *//* params.setHighlight(true);
            //指定高亮域
            params.addHighlightField("venueName");
            //设置前缀
            params.setHighlightSimplePre("<span style='color:red'>");
            //设置后缀
            params.setHighlightSimplePost("</span>");

            //查询后返回的对象
            QueryResponse queryResponse = client.query("core1",params);
            //查询后返回的对象 获得真正的查询结果
            SolrDocumentList results = queryResponse.getResults();
            //查询的总条数
           // long numFound = results.getNumFound();

           // System.out.println(numFound);

            //获取高亮显示的结果, 高亮显示的结果和查询结果是分开放的
            Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();

            //创建list集合接收我们循环的参数
            List<VenueBean> list1 =new ArrayList<>();
            for (SolrDocument result : results) {

                VenueBean car1=new VenueBean();
                String highFile="";

                Map<String, List<String>> map = highlight.get(result.get("id"));
                List<String> list = map.get("venueName");
                if(list==null){
                    highFile= result.get("venueName").toString();
                }else {
                    highFile=list.get(0);
                }

              *//**//*  car1.setVenueId(Integer.parseInt(result.get("id").toString()));
                car1.setVenueName((String) result.get("venueName"));
                car1.setVenueAddress(result.get("venueAddress").toString());
                car1.setPrice(Integer.parseInt(result.get("id").toString()));
                car1.venueName(highFile);*//**//*

               // list1.add(car1);
            }
         *//**//*   map1.put("total",numFound);
            map1.put("rows",list1);*//**//*
            return map1;*//*

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }*/





}
