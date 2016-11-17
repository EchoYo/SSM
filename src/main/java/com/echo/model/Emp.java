package com.echo.model;

import java.io.Serializable;

/**
 * <p>Description:员工表</p>
 * Created by Echoj on 2016-06-24.
 */
public class Emp implements Serializable {
    private Long id;
    private String empId;
    private String workId;
    private String cardId;
    private String deptId;
    private String empName;
    private String sex;
    //身份证号
    private String identityId;
    private String birthday;
    //工作组
    private String teamId;
    //班次
    private String shiftId;
    //学历
    private String education;
    //岗位
    private String postName;
    //公积金类型
    private String cpfId;
    //保险类型
    private String insurance;
    //入职日期
    private String entryDate;
    //离职日期
    private String leaveDate;
    //离职状态
    private String leaveYN = "N";
    //现居住地
    private String homeAddress;
    //户籍地址
    private String tmpAddress;
    //转正日期
    private String formalDate;
    //手机号
    private String phone;
    //备注
    private String remarks;
    //用工性质
    private String natureId;
    //合同生效日期
    private String contractStart;
    //合同到期日期
    private String contractEnd;
    //合同路径
    private String contractPath;

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

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getCpfId() {
        return cpfId;
    }

    public void setCpfId(String cpfId) {
        this.cpfId = cpfId;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

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

    public String getLeaveYN() {
        return leaveYN;
    }

    public void setLeaveYN(String leaveYN) {
        this.leaveYN = leaveYN;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getTmpAddress() {
        return tmpAddress;
    }

    public void setTmpAddress(String tmpAddress) {
        this.tmpAddress = tmpAddress;
    }

    public String getFormalDate() {
        return formalDate;
    }

    public void setFormalDate(String formalDate) {
        this.formalDate = formalDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getNatureId() {
        return natureId;
    }

    public void setNatureId(String natureId) {
        this.natureId = natureId;
    }

    public String getContractStart() {
        return contractStart;
    }

    public void setContractStart(String contractStart) {
        this.contractStart = contractStart;
    }

    public String getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(String contractEnd) {
        this.contractEnd = contractEnd;
    }

    public String getContractPath() {
        return contractPath;
    }

    public void setContractPath(String contractPath) {
        this.contractPath = contractPath;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", workId='" + workId + '\'' +
                ", cardId='" + cardId + '\'' +
                ", deptId='" + deptId + '\'' +
                ", empName='" + empName + '\'' +
                ", sex='" + sex + '\'' +
                ", identityId='" + identityId + '\'' +
                ", birthday='" + birthday + '\'' +
                ", teamId='" + teamId + '\'' +
                ", shiftId='" + shiftId + '\'' +
                ", education='" + education + '\'' +
                ", postName='" + postName + '\'' +
                ", cpfId='" + cpfId + '\'' +
                ", insurance='" + insurance + '\'' +
                ", entryDate='" + entryDate + '\'' +
                ", leaveDate='" + leaveDate + '\'' +
                ", leaveYN='" + leaveYN + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", tmpAddress='" + tmpAddress + '\'' +
                ", formalDate='" + formalDate + '\'' +
                ", phone='" + phone + '\'' +
                ", remarks='" + remarks + '\'' +
                ", natureId='" + natureId + '\'' +
                ", contractStart='" + contractStart + '\'' +
                ", contractEnd='" + contractEnd + '\'' +
                ", contractPath='" + contractPath + '\'' +
                '}';
    }
}
