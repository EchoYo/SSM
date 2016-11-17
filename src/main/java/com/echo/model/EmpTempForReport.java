package com.echo.model;

import java.io.Serializable;

/**
 * <p>Description:报告用自定义</p>
 * Created by Echoj on 2016-08-23.
 */
public class EmpTempForReport implements Serializable {
    private String deptName;
    private String workId;
    private String empName;
    private String deptId;
    private String leaveDate;
    private String entryDate;


    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "EmpTempForReport{" +
                "deptName='" + deptName + '\'' +
                ", workId='" + workId + '\'' +
                ", empName='" + empName + '\'' +
                ", deptId='" + deptId + '\'' +
                '}';
    }
}
