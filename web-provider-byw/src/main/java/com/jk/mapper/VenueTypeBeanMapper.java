package com.jk.mapper;

import com.jk.model.VenueBean;
import com.jk.model.VenueTypeBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface VenueTypeBeanMapper {

    List<VenueTypeBean> queryVenueType();

    List<VenueBean> queryVenue(@Param("typeId") Integer typeId);
}