package com.echo.model;

/**
 * <p>Description:文控图纸</p>
 * Created by Echoj on 2016-06-08.
 */
public class Drawing {
    private Long id;
    private String date;
    private String sampleDrawingEdition;
    private String customerName;
    private String customerDrawingName;
    private String customerDrawingNumber;
    private String customerDrawingEdition;
    private String moldDrawingEdition;
    private String moldDrawingDate;
    private String formalDrawingEdition;
    private String formalDrawingDate;
    private String craftNumber;
    private String craftEdition;
    private String craftDate;
    private String formalMoldDrawingEdition;
    private String formalMoldDrawingDate;
    private String remark;

    public String getFormalMoldDrawingEdition() {
        return formalMoldDrawingEdition;
    }

    public void setFormalMoldDrawingEdition(String formalMoldDrawingEdition) {
        this.formalMoldDrawingEdition = formalMoldDrawingEdition;
    }

    public String getFormalMoldDrawingDate() {
        return formalMoldDrawingDate;
    }

    public void setFormalMoldDrawingDate(String formalMoldDrawingDate) {
        this.formalMoldDrawingDate = formalMoldDrawingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSampleDrawingEdition() {
        return sampleDrawingEdition;
    }

    public void setSampleDrawingEdition(String sampleDrawingEdition) {
        this.sampleDrawingEdition = sampleDrawingEdition;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerDrawingName() {
        return customerDrawingName;
    }

    public void setCustomerDrawingName(String customerDrawingName) {
        this.customerDrawingName = customerDrawingName;
    }

    public String getCustomerDrawingNumber() {
        return customerDrawingNumber;
    }

    public void setCustomerDrawingNumber(String customerDrawingNumber) {
        this.customerDrawingNumber = customerDrawingNumber;
    }

    public String getCustomerDrawingEdition() {
        return customerDrawingEdition;
    }

    public void setCustomerDrawingEdition(String customerDrawingEdition) {
        this.customerDrawingEdition = customerDrawingEdition;
    }

    public String getMoldDrawingEdition() {
        return moldDrawingEdition;
    }

    public void setMoldDrawingEdition(String moldDrawingEdition) {
        this.moldDrawingEdition = moldDrawingEdition;
    }

    public String getMoldDrawingDate() {
        return moldDrawingDate;
    }

    public void setMoldDrawingDate(String moldDrawingDate) {
        this.moldDrawingDate = moldDrawingDate;
    }

    public String getFormalDrawingEdition() {
        return formalDrawingEdition;
    }

    public void setFormalDrawingEdition(String formalDrawingEdition) {
        this.formalDrawingEdition = formalDrawingEdition;
    }

    public String getFormalDrawingDate() {
        return formalDrawingDate;
    }

    public void setFormalDrawingDate(String formalDrawingDate) {
        this.formalDrawingDate = formalDrawingDate;
    }

    public String getCraftNumber() {
        return craftNumber;
    }

    public void setCraftNumber(String craftNumber) {
        this.craftNumber = craftNumber;
    }

    public String getCraftEdition() {
        return craftEdition;
    }

    public void setCraftEdition(String craftEdition) {
        this.craftEdition = craftEdition;
    }

    public String getCraftDate() {
        return craftDate;
    }

    public void setCraftDate(String craftDate) {
        this.craftDate = craftDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Drawing{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", sampleDrawingEdition='" + sampleDrawingEdition + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerDrawingName='" + customerDrawingName + '\'' +
                ", customerDrawingNumber='" + customerDrawingNumber + '\'' +
                ", customerDrawingEdition='" + customerDrawingEdition + '\'' +
                ", moldDrawingEdition='" + moldDrawingEdition + '\'' +
                ", moldDrawingDate='" + moldDrawingDate + '\'' +
                ", formalDrawingEdition='" + formalDrawingEdition + '\'' +
                ", formalDrawingDate='" + formalDrawingDate + '\'' +
                ", craftNumber='" + craftNumber + '\'' +
                ", craftEdition='" + craftEdition + '\'' +
                ", craftDate='" + craftDate + '\'' +
                ", formalMoldDrawingEdition='" + formalMoldDrawingEdition + '\'' +
                ", formalMoldDrawingDate='" + formalMoldDrawingDate + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
