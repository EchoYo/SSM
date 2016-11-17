package com.echo.model;

/**
 * <p>Description:erp查询存货名</p>
 * Created by Echoj on 2016-06-24.
 */
public class Inventory {
    private String cInvCode;
    private String cInvAddCode;
    private String cInvName;

    public String getcInvCode() {
        return cInvCode;
    }

    public void setcInvCode(String cInvCode) {
        this.cInvCode = cInvCode;
    }

    public String getcInvAddCode() {
        return cInvAddCode;
    }

    public void setcInvAddCode(String cInvAddCode) {
        this.cInvAddCode = cInvAddCode;
    }

    public String getcInvName() {
        return cInvName;
    }

    public void setcInvName(String cInvName) {
        this.cInvName = cInvName;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "cInvCode='" + cInvCode + '\'' +
                ", cInvAddCode='" + cInvAddCode + '\'' +
                ", cInvName='" + cInvName + '\'' +
                '}';
    }
}
