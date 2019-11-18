package com.jk.model;

import java.io.Serializable;

public class VenueTypeBean implements Serializable {
    private static final long serialVersionUID = 8483991905664687535L;
    private Integer typeId;

    private String typeName;

    public Integer getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}