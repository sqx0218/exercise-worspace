package com.jk.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Venueb;
import com.jk.service.ZhyService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 */

@Controller
@RequestMapping("zhy")
public class ZhyController {

    @Reference
    private ZhyService zhyService;

    @RequestMapping("insert")
    @ResponseBody
    public int insert(Venueb venueb) {
        int b = zhyService.insert(venueb);
        if (b == 1) {
            return 3;
        }
        return 4;
    }


    /**
     * 通过
     *
     * @param venueb
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public int update(Venueb venueb) {
        zhyService.update(venueb);
        return 3;
    }


    /**
     * 未通过
     *
     * @param venueb
     * @return
     */
    @RequestMapping("update2")
    @ResponseBody
    public int update2(Venueb venueb) {
        zhyService.update2(venueb);
        return 3;
    }


    @RequestMapping("chaxun")
    @ResponseBody
    public List<Venueb> query() {
        System.out.println();
        return zhyService.query();
    }


    @RequestMapping("query2")
    @ResponseBody
    public List<Venueb> query2(int venueastatus) {
        System.out.println(venueastatus);
        return zhyService.query2(venueastatus);
    }


    @RequestMapping("query3")
    @ResponseBody
    public List<Venueb> query3(int venueastatus) {
        System.out.println(venueastatus);
        return zhyService.query3(venueastatus);
    }


    @RequestMapping("get")
    public String  get(){
        return "zhy";
    }

    @RequestMapping("zz")
    public String  zz(){
        return "form";
    }
    @RequestMapping("tongguo")
    public String  tongguo(){
        return "tongguo";
    }
    @RequestMapping("weitonggguo")
    public String  weitonggguo(){
        return "weitonggguo";
    }
}



