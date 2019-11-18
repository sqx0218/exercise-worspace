package com.jk.model;

import java.util.Date;

public class UserInfo {
    private Integer userId;

    private Date userBir;

    private String phone;

    private Double userHeight;

    private Double userWeight;

    private Integer userAge;

    private Integer userSex;

    private String userPhoto;

    private Integer vipTypeId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getUserBir() {
        return userBir;
    }

    public void setUserBir(Date userBir) {
        this.userBir = userBir;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Double getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(Double userHeight) {
        this.userHeight = userHeight;
    }

    public Double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(Double userWeight) {
        this.userWeight = userWeight;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto == null ? null : userPhoto.trim();
    }

    public Integer getVipTypeId() {
        return vipTypeId;
    }

    public void setVipTypeId(Integer vipTypeId) {
        this.vipTypeId = vipTypeId;
    }
}