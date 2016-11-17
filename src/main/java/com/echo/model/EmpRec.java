package com.echo.model;

import java.io.Serializable;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-08-03.
 */
public class EmpRec implements Serializable {
    private String empId;
    private String empName;
    private String workId;
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    @Override
    public String toString() {
        return "EmpRec{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", workId='" + workId + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
