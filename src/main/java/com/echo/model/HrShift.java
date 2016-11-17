package com.echo.model;

/**
 * <p>Description:班次详情</p>
 * Created by Echoj on 2016-08-19.
 */
public class HrShift {
    private int id;
    private String shiftId;
    private String shiftName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }
}
