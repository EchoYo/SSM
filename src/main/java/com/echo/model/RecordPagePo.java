package com.echo.model;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-08-01.
 */
public class RecordPagePo{
    private String stDate;
    private String endDate;
    private String month;
    private String deptId;
    private String empName;

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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "RecordPagePo{" +
                "stDate='" + stDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", month='" + month + '\'' +
                ", deptId='" + deptId + '\'' +
                ", empName='" + empName + '\'' +
                '}';
    }
}
