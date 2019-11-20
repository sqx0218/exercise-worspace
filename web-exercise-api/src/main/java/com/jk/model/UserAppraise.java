package com.jk.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document(collection="AppraiseInfo")
public class UserAppraise implements Serializable {
    private Integer infoId;

    private Integer venueId;

    private String praiseInfo;
    private Integer pid;


    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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