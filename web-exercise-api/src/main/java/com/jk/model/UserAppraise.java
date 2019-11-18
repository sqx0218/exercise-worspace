package com.jk.model;

public class UserAppraise {
    private Integer userId;

    private Integer venueId;

    private String praiseInfo;

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

    public String getPraiseInfo() {
        return praiseInfo;
    }

    public void setPraiseInfo(String praiseInfo) {
        this.praiseInfo = praiseInfo == null ? null : praiseInfo.trim();
    }
}