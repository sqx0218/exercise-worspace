package com.jk.service;

import com.jk.model.Venueb;

import java.util.List;


public interface ZhyService {

    int insert(Venueb venueb);

    int update(Venueb venueb);

    int update2(Venueb venueb);

    List<Venueb> query();

    List<Venueb> query2(int venueastatus);

    List<Venueb> query3(int venueastatus);
}
