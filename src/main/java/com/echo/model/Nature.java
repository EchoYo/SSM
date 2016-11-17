package com.echo.model;

import java.io.Serializable;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-07-06.
 */
public class Nature implements Serializable {
    private Long id;
    private String natureId;
    private String natureName;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNatureId() {
        return natureId;
    }

    public void setNatureId(String natureId) {
        this.natureId = natureId;
    }

    public String getNatureName() {
        return natureName;
    }

    public void setNatureName(String natureName) {
        this.natureName = natureName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
