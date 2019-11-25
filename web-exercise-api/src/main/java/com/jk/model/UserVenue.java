package com.jk.model;

import java.io.Serializable;

/**
 * @ClassName UserVenue
 * @Deacription TODO
 * @Author wss
 * @Date 2019/11/21 23:21
 * @Version 1.0
 **/
public class UserVenue implements Serializable {

    private Integer Id;
    private Integer userId;
    private Integer venueId;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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
}
