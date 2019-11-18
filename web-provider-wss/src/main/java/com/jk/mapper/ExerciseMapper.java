package com.jk.mapper;

import com.jk.model.Venue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExerciseMapper {
    @Select("select * from t_venue")
    List<Venue> queryVenue();
}
