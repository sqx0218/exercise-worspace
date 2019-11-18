package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Venue;

import com.jk.service.ExerciseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("exercise")
public class ExerciseController {

    @Reference
    private ExerciseService exerciseService;




    @RequestMapping("queryVenue")
    public List<Venue> queryVenue(){
        return  exerciseService.queryVenue();
    }

}
