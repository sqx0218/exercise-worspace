package com.jk.mapper;

import com.jk.model.UserAppraise;
import com.jk.model.Venue;
import com.jk.model.timeModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExerciseMapper {

    List<Venue> queryVenue();

    List<UserAppraise> queryAppraise();

    List<timeModel> queryList();
    @Update("update  t_venue set venueLike='2' where venueId=#{value}")
    void updatevuen(Integer venueId);
    @Update("update t_venue set venueLike='1' where venueId=#{value}")
    void updatevuen2(Integer venueId);
}
