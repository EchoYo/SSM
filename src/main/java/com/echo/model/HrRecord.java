package com.echo.model;

import java.io.Serializable;

/**
 * <p>Description:mysql刷卡明细</p>
 * Created by Echoj on 2016-07-08.
 */
public class HrRecord implements Serializable{
    private int id;
    private String empId;
    private String cardId;
    private String recDate;
    private String recTime;
    private String equNo;
    private String operId;
    private String operDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getRecDate() {
        return recDate;
    }

    public void setRecDate(String recDate) {
        this.recDate = recDate;
    }

    public String getRecTime() {
        return recTime;
    }

    public void setRecTime(String recTime) {
        this.recTime = recTime;
    }

    public String getEquNo() {
        return equNo;
    }

    public void setEquNo(String equNo) {
        this.equNo = equNo;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HrRecord hrRecord = (HrRecord) o;

        if (!empId.equals(hrRecord.empId)) return false;
        if (!cardId.equals(hrRecord.cardId)) return false;
        if (!recDate.equals(hrRecord.recDate)) return false;
        if (!recTime.equals(hrRecord.recTime)) return false;
        return equNo.equals(hrRecord.equNo);

    }

    @Override
    public int hashCode() {
        int result = empId.hashCode();
        result = 31 * result + cardId.hashCode();
        result = 31 * result + recDate.hashCode();
        result = 31 * result + recTime.hashCode();
        result = 31 * result + equNo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "HrRecord{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", cardId='" + cardId + '\'' +
                ", recDate='" + recDate + '\'' +
                ", recTime='" + recTime + '\'' +
                ", equNo='" + equNo + '\'' +
                ", operId='" + operId + '\'' +
                ", operDate='" + operDate + '\'' +
                '}';
    }
}
