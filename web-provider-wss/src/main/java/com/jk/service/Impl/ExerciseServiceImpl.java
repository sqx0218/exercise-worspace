package com.jk.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.ExerciseMapper;
import com.jk.model.*;
import com.jk.service.ExerciseService;
import com.jk.utils.BadWordUtil2;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.*;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseMapper exerciseMapper;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Venue> queryVenues() {

        List<Venue> list = exerciseMapper.queryVenues();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return list;
    }

    @Override
    public List<UserVenue> queryUserLike(String userName) {
        return exerciseMapper.queryUserLike(userName);
    }

    @Override
    public HashMap<String, Object> queryAppraise(Integer venueId, Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<>();

        Query query = new Query();
        long count = mongoTemplate.count(query, UserAppraise.class);
        int start = (page - 1) * rows;
        query.skip(start).limit(rows);
        List<UserAppraise> venue = mongoTemplate.find(query, UserAppraise.class);

        map.put("total", count);
        map.put("rows", venue);
        return map;
    }

    @Override
    public List<timeModel> queryList() {
        return exerciseMapper.queryList();
    }

    @Override
    public void addPayment(OrderInfo orderInfo) {
        orderInfo.setOrderTime(new Date());
        orderInfo.setOrderStatus(1);
        orderInfo.setUserId(1);
        orderInfo.setOrderNum(String.valueOf(new Date().getTime()));
        exerciseMapper.addPayment(orderInfo);
        mongoTemplate.save(orderInfo);

    }

    @Override
    public void venuelike(Integer venueId, Integer likeid) {
        if (likeid == 1) {
            exerciseMapper.updatevuen(venueId);
        }
        if (likeid == 2) {
            exerciseMapper.updatevuen2(venueId);
        }
    }

    @Override
    public void appadd(UserAppraise userAppraise) {

        Set<String> s = BadWordUtil2.words;
        System.out.println("敏感词的数量：" + BadWordUtil2.wordMap.size());
        //要发布的内容
        String string = userAppraise.getPraiseInfo();
        System.out.println("待检测语句字数：" + string.length());
        //要发布内容中的敏感词
        Set<String> set = BadWordUtil2.getBadWord(string, 2);
        System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();

            String qq = "";
            for (int i = 0; i < next.length(); i++) {
                qq += "*";
            }
            string = string.replaceAll(next, qq);
        }
        userAppraise.setPraiseInfo(string);
        mongoTemplate.save(userAppraise);
    }


}
