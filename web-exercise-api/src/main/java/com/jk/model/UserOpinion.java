package com.jk.model;

import java.util.Date;

public class UserOpinion {
    private Integer userId;

    private Integer venueId;

    private String opinionInfo;

    private Date opinTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getOpinionInfo() {
        return opinionInfo;
    }

    public void setOpinionInfo(String opinionInfo) {
        this.opinionInfo = opinionInfo == null ? null : opinionInfo.trim();
    }

    public Date getOpinTime() {
        return opinTime;
    }

    public void setOpinTime(Date opinTime) {
        this.opinTime = opinTime;
    }
}