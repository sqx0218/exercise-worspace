package com.jk.controller;


import com.jk.model.Venueb;
import com.jk.service.ZhyService;
import jdk.nashorn.internal.ir.annotations.Reference;
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
    public int insert(Venueb venueb){
        int b = zhyService.insert(venueb);
        if(b==1){
            return 3;
        }
            return 4;
    }


    /**
     * 通过
     * @param venueb
     * @return
     */
    public int update(Venueb venueb){
        zhyService.update(venueb);
        return 3;
    }


    /**
     * 未通过
     * @param venueb
     * @return
     */
    public int update2(Venueb venueb){
        zhyService.update2(venueb);
        return 3;
    }

    public List<Venueb> query(int status){
        return zhyService.query(status);
    }



}
