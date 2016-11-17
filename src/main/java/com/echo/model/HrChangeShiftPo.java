package com.echo.model;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-09-05.
 */
public class HrChangeShiftPo {
    private String empId;
    private String stDate;
    private String endDate;
    private String operId;
    private String operDate;

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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
        return "HrChangeShiftPo{" +
                "empId='" + empId + '\'' +
                ", stDate='" + stDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", operId='" + operId + '\'' +
                ", operDate='" + operDate + '\'' +
                '}';
    }
}
