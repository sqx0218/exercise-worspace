package com.jk.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.TypeMapper;
import com.jk.model.Type;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName TypeServiceImpl
 * @Description: TODO
 * @Author 梁浩
 * @Date 2019/11/15
 * @Version V1.0
 **/
@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeMapper typeMapper;
    /* * @MethodName:查全部类型
     * @Description: 查场馆类型
     * @Param:null
     * @Return: list
     * @Author: 梁浩
     * @Date: 2019/11/15
    **/
    public List<Type> queryTypeList() {
        List<Type> typeList = typeMapper.queryTypeList();
        return typeList;
    }
}
