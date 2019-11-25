package com.jk.mapper;

import com.jk.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface LoginMapper {

    List<String> queryPowerByUserid(Integer id);
    @Select("select * from t_user where userName=#{value}")
    User findUserByName(String userName);
    @Insert("INSERT INTO t_user(userName,PASSWORD,CREATETIME) VALUES(#{loginz},#{loginm},SYSDATE())")
    void RegisterUser(@Param("loginz")String loginz,@Param("loginm")String loginm);
    @Select("SELECT*from t_user where phone=#{phone}")
    User getPhone(@Param("phone") String phone);

    //User findUserInfoByAccount(String phone);
}
