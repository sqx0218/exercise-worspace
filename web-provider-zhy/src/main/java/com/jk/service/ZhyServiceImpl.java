package com.jk.service;

import com.jk.mapper.ZhyMapper;
import com.jk.model.Venueb;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;

@Service
public class ZhyServiceImpl   implements ZhyService  {

    @Autowired
    private ZhyMapper zhyMapper;

    @Override
    public int insert(Venueb venueb) {
        int a = zhyMapper.insert(venueb);
        if(a>0){
            return 1;
        }else{
            return 0;
        }


    }

    @Override
    public int update(Venueb venueb) {
        int update = zhyMapper.update(venueb);
        if (update > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int update2(Venueb venueb) {
        int update2 = zhyMapper.update2(venueb);
        if (update2 > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<Venueb> query(int status) {
        return zhyMapper.query(status);
    }
}
