package com.echo.model;

/**
 * <p>Description:请假登记表</p>
 * Created by Echoj on 2016-08-15.
 */
public class HrRecLeave {
    private Integer id;
    private String empId;
    private String resultType;
    private String stDate;
    private String stTime;
    private String endDate;
    private String endTime;
    private String hours;
    private String remark;
    private String operId;
    private String operDate;


    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getStDate() {
        return stDate;
    }

    public void setStDate(String stDate) {
        this.stDate = stDate;
    }

    public String getStTime() {
        return stTime;
    }

    public void setStTime(String stTime) {
        this.stTime = stTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        return "HrRecLeave{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", resultType='" + resultType + '\'' +
                ", stDate='" + stDate + '\'' +
                ", stTime='" + stTime + '\'' +
                ", endDate='" + endDate + '\'' +
                ", endTime='" + endTime + '\'' +
                ", hours='" + hours + '\'' +
                ", remark='" + remark + '\'' +
                ", operId='" + operId + '\'' +
                ", operDate='" + operDate + '\'' +
                '}';
    }
}
