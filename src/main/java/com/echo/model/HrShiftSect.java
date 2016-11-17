package com.echo.model;

/**
 * <p>Description:班次时间段</p>
 * Created by Echoj on 2016-08-23.
 */
public class HrShiftSect {
    private int id;
    private String shiftId;
    private String shiftSectId;
    private String stRecTime;
    private String stAtdTime;
    private String endAtdTime;
    private String endRecTime;

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

    public String getShiftSectId() {
        return shiftSectId;
    }

    public void setShiftSectId(String shiftSectId) {
        this.shiftSectId = shiftSectId;
    }

    public String getStRecTime() {
        return stRecTime;
    }

    public void setStRecTime(String stRecTime) {
        this.stRecTime = stRecTime;
    }

    public String getStAtdTime() {
        return stAtdTime;
    }

    public void setStAtdTime(String stAtdTime) {
        this.stAtdTime = stAtdTime;
    }

    public String getEndAtdTime() {
        return endAtdTime;
    }

    public void setEndAtdTime(String endAtdTime) {
        this.endAtdTime = endAtdTime;
    }

    public String getEndRecTime() {
        return endRecTime;
    }

    public void setEndRecTime(String endRecTime) {
        this.endRecTime = endRecTime;
    }
}
