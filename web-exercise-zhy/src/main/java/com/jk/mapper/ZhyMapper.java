package com.jk.mapper;

import com.jk.model.Venueb;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ZhyMapper {
    int insert(Venueb venueb);

    int update(Venueb venueb);

    int update2(Venueb venueb);

    List<Venueb> query();

    List<Venueb> query2(int venueastatus);

    List<Venueb> query3(int venueastatus);
}