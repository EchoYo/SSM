package com.echo.model;

/**
 * <p>Description:排班表</p>
 * Created by Echoj on 2016-07-25.
 */
public class HrRecShift {
    private Long id;
    private String empId;
    private String stDate;
    private String shiftId;
    private String operId;
    private String operDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getStDate() {
        return stDate;
    }

    public void setStDate(String stDate) {
        this.stDate = stDate;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }

    public String getOperDate() {
        return operDate;
    }

    public void setOperDate(String operDate) {
        this.operDate = operDate;
    }

    @Override
    public String toString() {
        return "HrRecShift{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", stDate='" + stDate + '\'' +
                ", shiftId='" + shiftId + '\'' +
                ", operId='" + operId + '\'' +
                ", operDate='" + operDate + '\'' +
                '}';
    }
}
