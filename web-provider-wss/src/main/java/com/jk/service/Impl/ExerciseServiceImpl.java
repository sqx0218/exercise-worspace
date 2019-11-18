package com.jk.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.ExerciseMapper;
import com.jk.model.Venue;
import com.jk.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseMapper exerciseMapper;

    @Override
    public List<Venue> queryVenue() {

        return exerciseMapper.queryVenue();
    }
}
