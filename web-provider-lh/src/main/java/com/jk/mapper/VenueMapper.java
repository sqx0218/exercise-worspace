package com.jk.mapper;

import com.jk.model.Venue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VenueMapper {


    List<Venue> queryFootballVenue(@Param("typeName") String typeName);
}