package com.echo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-08-06.
 */
public class HrRecShiftCustom implements Serializable {
    private Long id;
    private String empId;
    private String empName;
    private String workId;
    private String shiftName;
    private String shiftId;
    private String stDate;
    private String endDate;
    private String month;
    private String deptName;
    private List<String> shiftIds = new ArrayList<String>();

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

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

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

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }


    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<String> getShiftIds() {
        return shiftIds;
    }

    public void setShiftIds(List<String> shiftIds) {
        this.shiftIds = shiftIds;
    }
}
