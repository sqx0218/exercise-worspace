package com.jk.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "AppraiseInfo")
public class UserAppraise implements Serializable {
    private Integer userId;
    private String userName;
    private Integer venueId;

    private String praiseInfo;
    private Integer pid;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPraiseInfo() {
        return praiseInfo;
    }

    public void setPraiseInfo(String praiseInfo) {
        this.praiseInfo = praiseInfo == null ? null : praiseInfo.trim();
    }
}