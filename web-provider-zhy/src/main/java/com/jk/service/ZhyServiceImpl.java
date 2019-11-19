package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.ZhyMapper;
import com.jk.model.Venueb;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ZhyServiceImpl implements  ZhyService {

    @Autowired
    private ZhyMapper zhyMapper;


    @Override
    public int insert(Venueb venueb) {
        int insert = zhyMapper.insert(venueb);
        if(insert>0){
            return 3;
        }
        return 4;
    }

    @Override
    public int update(Venueb venueb) {
        int update = zhyMapper.update(venueb);
        if(update>0){
            return 3;
        }

        return 4;
    }

    @Override
    public int update2(Venueb venueb) {
        int update = zhyMapper.update2(venueb);
        if(update>0){
            return 3;
        }

        return 4;
    }

    @Override
    public List<Venueb> query(int status) {
        return zhyMapper.query(status);
    }
}
