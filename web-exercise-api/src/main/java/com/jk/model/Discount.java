package com.jk.model;

public class Discount {
    private Integer discId;

    private String discName;

    private Integer userId;

    private Integer venueId;

    private String discInfo;

    public Integer getDiscId() {
        return discId;
    }

    public void setDiscId(Integer discId) {
        this.discId = discId;
    }

    public String getDiscName() {
        return discName;
    }

    public void setDiscName(String discName) {
        this.discName = discName == null ? null : discName.trim();
    }

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

    public String getDiscInfo() {
        return discInfo;
    }

    public void setDiscInfo(String discInfo) {
        this.discInfo = discInfo == null ? null : discInfo.trim();
    }
}