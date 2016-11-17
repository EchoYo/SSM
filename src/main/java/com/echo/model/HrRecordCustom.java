package com.echo.model;

import java.io.Serializable;

/**
 * <p>Description:刷卡记录自定义类</p>
 * Created by Echoj on 2016-07-27.
 */
public class HrRecordCustom implements Serializable{
    private Long id;
    private String empId;
    private String cardId;
    private String empName;
    private String deptName;
    private String workId;
    private String recDate;
    private String equNo;
    private String dayOfWeek;
    private String recTime1;
    private String recTime2;
    private String recTime3;
    private String recTime4;
    private String operId;
    private String operDate;

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

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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

    public String getRecDate() {
        return recDate;
    }

    public void setRecDate(String recDate) {
        this.recDate = recDate;
    }

    public String getEquNo() {
        return equNo;
    }

    public void setEquNo(String equNo) {
        this.equNo = equNo;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getRecTime1() {
        return recTime1;
    }

    public void setRecTime1(String recTime1) {
        this.recTime1 = recTime1;
    }

    public String getRecTime2() {
        return recTime2;
    }

    public void setRecTime2(String recTime2) {
        this.recTime2 = recTime2;
    }

    public String getRecTime3() {
        return recTime3;
    }

    public void setRecTime3(String recTime3) {
        this.recTime3 = recTime3;
    }

    public String getRecTime4() {
        return recTime4;
    }

    public void setRecTime4(String recTime4) {
        this.recTime4 = recTime4;
    }

    @Override
    public String toString() {
        return "HrRecordCustom{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", cardId='" + cardId + '\'' +
                ", empName='" + empName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", workId='" + workId + '\'' +
                ", recDate='" + recDate + '\'' +
                ", equNo='" + equNo + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", recTime1='" + recTime1 + '\'' +
                ", recTime2='" + recTime2 + '\'' +
                ", recTime3='" + recTime3 + '\'' +
                ", recTime4='" + recTime4 + '\'' +
                '}';
    }
}
