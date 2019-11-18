package com.jk.model;

import java.io.Serializable;
import java.util.Date;

public class Venue implements Serializable {
    private Integer venueid;

    private String venuename;

    private String venueaddress;

    private Double price;

    private Date dotime;

    private String img;

    private String venueserver;

    private String venuemetro;

    private String venuecar;

    private String venuelease;

    private String venuemaintain;

    private String venuemore;

    private String venuebath;

    private String venuegoods;

    private String venueinvoice;

    private String venuepark;

    private String venuehint;

    private Integer vipid;

    private Integer venuephone;

    private String venuetypename;

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
        this.venuename = venuename == null ? null : venuename.trim();
    }

    public String getVenueaddress() {
        return venueaddress;
    }

    public void setVenueaddress(String venueaddress) {
        this.venueaddress = venueaddress == null ? null : venueaddress.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDotime() {
        return dotime;
    }

    public void setDotime(Date dotime) {
        this.dotime = dotime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getVenueserver() {
        return venueserver;
    }

    public void setVenueserver(String venueserver) {
        this.venueserver = venueserver == null ? null : venueserver.trim();
    }

    public String getVenuemetro() {
        return venuemetro;
    }

    public void setVenuemetro(String venuemetro) {
        this.venuemetro = venuemetro == null ? null : venuemetro.trim();
    }

    public String getVenuecar() {
        return venuecar;
    }

    public void setVenuecar(String venuecar) {
        this.venuecar = venuecar == null ? null : venuecar.trim();
    }

    public String getVenuelease() {
        return venuelease;
    }

    public void setVenuelease(String venuelease) {
        this.venuelease = venuelease == null ? null : venuelease.trim();
    }

    public String getVenuemaintain() {
        return venuemaintain;
    }

    public void setVenuemaintain(String venuemaintain) {
        this.venuemaintain = venuemaintain == null ? null : venuemaintain.trim();
    }

    public String getVenuemore() {
        return venuemore;
    }

    public void setVenuemore(String venuemore) {
        this.venuemore = venuemore == null ? null : venuemore.trim();
    }

    public String getVenuebath() {
        return venuebath;
    }

    public void setVenuebath(String venuebath) {
        this.venuebath = venuebath == null ? null : venuebath.trim();
    }

    public String getVenuegoods() {
        return venuegoods;
    }

    public void setVenuegoods(String venuegoods) {
        this.venuegoods = venuegoods == null ? null : venuegoods.trim();
    }

    public String getVenueinvoice() {
        return venueinvoice;
    }

    public void setVenueinvoice(String venueinvoice) {
        this.venueinvoice = venueinvoice == null ? null : venueinvoice.trim();
    }

    public String getVenuepark() {
        return venuepark;
    }

    public void setVenuepark(String venuepark) {
        this.venuepark = venuepark == null ? null : venuepark.trim();
    }

    public String getVenuehint() {
        return venuehint;
    }

    public void setVenuehint(String venuehint) {
        this.venuehint = venuehint == null ? null : venuehint.trim();
    }

    public Integer getVipid() {
        return vipid;
    }

    public void setVipid(Integer vipid) {
        this.vipid = vipid;
    }

    public Integer getVenuephone() {
        return venuephone;
    }

    public void setVenuephone(Integer venuephone) {
        this.venuephone = venuephone;
    }

    public String getVenuetypename() {
        return venuetypename;
    }

    public void setVenuetypename(String venuetypename) {
        this.venuetypename = venuetypename == null ? null : venuetypename.trim();
    }
}