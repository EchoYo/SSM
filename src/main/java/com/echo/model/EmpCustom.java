package com.echo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description:emp自定义类</p>
 * Created by Echoj on 2016-06-29.
 */
public class EmpCustom implements Serializable {
    private String id;
    private String deptName;
    private String teamName;
    private String shiftName;
    private String cpfName;
    private String educationName;
    private String natureName;
    private Emp emp;
    //打卡记录
    private List<List<String>> records = new ArrayList<List<String>>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNatureName() {
        return natureName;
    }

    public void setNatureName(String natureName) {
        this.natureName = natureName;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public String getCpfName() {
        return cpfName;
    }

    public void setCpfName(String cpfName) {
        this.cpfName = cpfName;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public List<List<String>> getRecords() {
        return records;
    }

    public void setRecords(List<List<String>> records) {
        this.records = records;
    }
}
