package com.jk.model;

import java.io.Serializable;

public class Venueb  implements Serializable {

    /**
     *主键id
     */
    private Integer venueid;

    /**
     * 场馆名称
     */
    private String venuename;

    /**
     * 联系人
     */
    private String venuepeople;

    public String getVenuepeople() {
        return venuepeople;
    }

    public void setVenuepeople(String venuepeople) {
        this.venuepeople = venuepeople;
    }

    /**
     * 联系方式
     */
    private String venuephone;

    /**
     * 城市
     */
    private String venuearea;


    /**
     * 详情地址
     */
    private String venueaddress;

    /**
     * @returns审批状态
     */

    private Integer venueastatus;


    public Integer getVenueastatus() {
        return venueastatus;
    }

    public void setVenueastatus(Integer venueastatus) {
        this.venueastatus = venueastatus;
    }

    public Integer getVenueid() {
        return venueid;
    }

    public void setVenueid(Integer venueid) {
        this.venueid = venueid;
    }

    public String getVenuename() {
        return venuename;
    }

    public void setVenuename(String venuename) {
        this.venuename = venuename;
    }

    public String getVenuephone() {
        return venuephone;
    }

    public void setVenuephone(String venuephone) {
        this.venuephone = venuephone;
    }

    public String getVenuearea() {
        return venuearea;
    }

    public void setVenuearea(String venuearea) {
        this.venuearea = venuearea;
    }

    public String getVenueaddress() {
        return venueaddress;
    }

    public void setVenueaddress(String venueaddress) {
        this.venueaddress = venueaddress;
    }
}
