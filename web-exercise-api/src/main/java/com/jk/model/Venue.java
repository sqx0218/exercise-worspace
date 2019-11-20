package com.jk.model;

import java.io.Serializable;
import java.util.Date;

public class Venue implements Serializable {
    private Integer venueId;

    private String venueName;

    private String venueAddress;

    private Double price;

    private String doTime;

    private String img;

    private String venueServer;

    private String venueMetro;

    private String venueCar;

    private String venueLease;

    private String venueMaintain;

    private String venueMore;

    private String venueBath;

    private String venueGoods;

    private String venueInvoice;

    private String venuePark;

    private String venueHint;

    private Integer vipId;

    private Integer venuePhone;

    private String venueTypeName;

    private String venueLike;

    public String getVenueLike() {
        return venueLike;
    }

    public void setVenueLike(String venueLike) {
        this.venueLike = venueLike;
    }

    public String getVenueTypeName() {
        return venueTypeName;
    }

    public void setVenueTypeName(String venueTypeName) {
        this.venueTypeName = venueTypeName;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName == null ? null : venueName.trim();
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress == null ? null : venueAddress.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDoTime() {
        return doTime;
    }

    public void setDoTime(String doTime) {
        this.doTime = doTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getVenueServer() {
        return venueServer;
    }

    public void setVenueServer(String venueServer) {
        this.venueServer = venueServer == null ? null : venueServer.trim();
    }

    public String getVenueMetro() {
        return venueMetro;
    }

    public void setVenueMetro(String venueMetro) {
        this.venueMetro = venueMetro == null ? null : venueMetro.trim();
    }

    public String getVenueCar() {
        return venueCar;
    }

    public void setVenueCar(String venueCar) {
        this.venueCar = venueCar == null ? null : venueCar.trim();
    }

    public String getVenueLease() {
        return venueLease;
    }

    public void setVenueLease(String venueLease) {
        this.venueLease = venueLease == null ? null : venueLease.trim();
    }

    public String getVenueMaintain() {
        return venueMaintain;
    }

    public void setVenueMaintain(String venueMaintain) {
        this.venueMaintain = venueMaintain == null ? null : venueMaintain.trim();
    }

    public String getVenueMore() {
        return venueMore;
    }

    public void setVenueMore(String venueMore) {
        this.venueMore = venueMore == null ? null : venueMore.trim();
    }

    public String getVenueBath() {
        return venueBath;
    }

    public void setVenueBath(String venueBath) {
        this.venueBath = venueBath == null ? null : venueBath.trim();
    }

    public String getVenueGoods() {
        return venueGoods;
    }

    public void setVenueGoods(String venueGoods) {
        this.venueGoods = venueGoods == null ? null : venueGoods.trim();
    }

    public String getVenueInvoice() {
        return venueInvoice;
    }

    public void setVenueInvoice(String venueInvoice) {
        this.venueInvoice = venueInvoice == null ? null : venueInvoice.trim();
    }

    public String getVenuePark() {
        return venuePark;
    }

    public void setVenuePark(String venuePark) {
        this.venuePark = venuePark == null ? null : venuePark.trim();
    }

    public String getVenueHint() {
        return venueHint;
    }

    public void setVenueHint(String venueHint) {
        this.venueHint = venueHint == null ? null : venueHint.trim();
    }

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public Integer getVenuePhone() {
        return venuePhone;
    }

    public void setVenuePhone(Integer venuePhone) {
        this.venuePhone = venuePhone;
    }


}