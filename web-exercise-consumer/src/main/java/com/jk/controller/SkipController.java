package com.jk.controller;

import com.jk.model.Venue;
import jdk.nashorn.internal.ir.ReturnNode;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName SkipController
 * @Description: 跳转层
 * @Author 梁浩
 * @Date 2019/11/15
 * @Version V1.0
 **/
@Controller
@RequestMapping("skip")
public class SkipController {
    @RequestMapping("toIndex")
    public  String toIndex(){
        return "index";
    }

    /**
     * 去展示足球页面
     * @return
     */
    @RequestMapping("toZuQiuShow")
    public  String toZuQiuShow(){
        return "index1";
    }



    @RequestMapping("toIndex2")
    public String toPingPong(){
        return "index2";
    }


    @RequestMapping("toIndex3")
    public String toIndex3(){
        return "index3";
    }

    @RequestMapping("toIndex4")
    public String toIndex4(){
        return "index4";
    }


    @RequestMapping("toIndex5")
    public String toIndex5(){
        return "index5";
    }

    @RequestMapping("toIndex6")
    public String toIndex6(){
        return "index6";
    }

    @RequestMapping("toIndex7")
    public String toIndex7(){
        return "index7";
    }

    @RequestMapping("toIndex8")
    public String toIndex8(){
        return "index8";
    }

    @RequestMapping("toIndex9")
    public String toIndex9(){
        return "index9";
    }

    @RequestMapping("toIndex10")
    public String toIndex10(){
        return "index10";
    }

    @RequestMapping("toIndex11")
    public String toIndex11(){
        return "index11";
    }

    @RequestMapping("toIndex12")
    public String toIndex12(){
        return "index12";
    }

    @RequestMapping("toIndex13")
    public String toIndex13(){
        return "index13";
    }


    @RequestMapping("toIndex14")
    public String toIndex14(){
        return "index14";
    }

    @RequestMapping("toIndex15")
    public String toIndex15(){
        return "index15";
    }

    @RequestMapping("toIndex16")
    public String toIndex16(){
        return "index16";
    }

    @RequestMapping("toIndex17")
    public String toIndex17(){
        return "index17";
    }

    @RequestMapping("toIndex18")
    public String toIndex18(){
        return "index18";
    }

    @RequestMapping("toIndex19")
    public String toIndex19(){
        return "index19";
    }

    @RequestMapping("toIndex20")
    public String toIndex20(){
        return "index20";
    }

    @RequestMapping("toIndex21")
    public String toIndex21(){
        return "index21";
    }



}
