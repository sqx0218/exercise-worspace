package com.jk.mapper;

import com.jk.model.Venueb;

import java.util.List;

public interface ZhyMapper {

    int insert(Venueb venueb);

    int update(Venueb venueb);

    int update2(Venueb venueb);

    List<Venueb> query(int status);
}
