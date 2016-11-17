package com.echo.model;

/**
 * <p>Description:报表</p>
 * Created by Echoj on 2016-08-19.
 */
public class HrReport {
    private Long id;
    private String empId;//人员编号
    private String deptName;//部门名称
    private String deptId;//部门Id
    private String workId; //工号
    private String recDate;//日期
    private String empName;//姓名
    private String shiftName;//班次名称
    private String stAtdTime;//上班打卡时间
    private String endAtdTime;//下班打卡时间
    private String sJieRi;//记节日出勤
    private String yChuQin;//应出勤
    private String sChuQin;//实际出勤
    private String ps;//平时加班
    private String gx;//公休加班
    private String jr;//节日加班
    private String salaryResult;//有薪假还是无薪假和病假
    private String resultType;//请假类型
    private String resultName;
    private String leaveHours;//请假工时
    private String kuangGong;//旷工
    private String late;//迟到
    private String lateMinutes;//迟到分钟数
    private String early;//早退
    private String earlyMinutes;//早退分钟数
    private String tripHours;//出差工时

    public String getsJieRi() {
        return sJieRi;
    }

    public void setsJieRi(String sJieRi) {
        this.sJieRi = sJieRi;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSalaryResult() {
        return salaryResult;
    }

    public void setSalaryResult(String salaryResult) {
        this.salaryResult = salaryResult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public String getStAtdTime() {
        return stAtdTime;
    }

    public void setStAtdTime(String stAtdTime) {
        this.stAtdTime = stAtdTime;
    }

    public String getEndAtdTime() {
        return endAtdTime;
    }

    public void setEndAtdTime(String endAtdTime) {
        this.endAtdTime = endAtdTime;
    }

    public String getyChuQin() {
        return yChuQin;
    }

    public void setyChuQin(String yChuQin) {
        this.yChuQin = yChuQin;
    }

    public String getsChuQin() {
        return sChuQin;
    }

    public void setsChuQin(String sChuQin) {
        this.sChuQin = sChuQin;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getGx() {
        return gx;
    }

    public void setGx(String gx) {
        this.gx = gx;
    }

    public String getJr() {
        return jr;
    }

    public void setJr(String jr) {
        this.jr = jr;
    }

    public String getLeaveHours() {
        return leaveHours;
    }

    public void setLeaveHours(String leaveHours) {
        this.leaveHours = leaveHours;
    }

    public String getKuangGong() {
        return kuangGong;
    }

    public void setKuangGong(String kuangGong) {
        this.kuangGong = kuangGong;
    }

    public String getLate() {
        return late;
    }

    public void setLate(String late) {
        this.late = late;
    }

    public String getLateMinutes() {
        return lateMinutes;
    }

    public void setLateMinutes(String lateMinutes) {
        this.lateMinutes = lateMinutes;
    }

    public String getEarly() {
        return early;
    }

    public void setEarly(String early) {
        this.early = early;
    }

    public String getEarlyMinutes() {
        return earlyMinutes;
    }

    public void setEarlyMinutes(String earlyMinutes) {
        this.earlyMinutes = earlyMinutes;
    }

    public String getTripHours() {
        return tripHours;
    }

    public void setTripHours(String tripHours) {
        this.tripHours = tripHours;
    }

    @Override
    public String toString() {
        return "HrReport{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deptId='" + deptId + '\'' +
                ", workId='" + workId + '\'' +
                ", recDate='" + recDate + '\'' +
                ", empName='" + empName + '\'' +
                ", shiftName='" + shiftName + '\'' +
                ", stAtdTime='" + stAtdTime + '\'' +
                ", endAtdTime='" + endAtdTime + '\'' +
                ", sJieRi='" + sJieRi + '\'' +
                ", yChuQin='" + yChuQin + '\'' +
                ", sChuQin='" + sChuQin + '\'' +
                ", ps='" + ps + '\'' +
                ", gx='" + gx + '\'' +
                ", jr='" + jr + '\'' +
                ", salaryResult='" + salaryResult + '\'' +
                ", resultType='" + resultType + '\'' +
                ", resultName='" + resultName + '\'' +
                ", leaveHours='" + leaveHours + '\'' +
                ", kuangGong='" + kuangGong + '\'' +
                ", late='" + late + '\'' +
                ", lateMinutes='" + lateMinutes + '\'' +
                ", early='" + early + '\'' +
                ", earlyMinutes='" + earlyMinutes + '\'' +
                ", tripHours='" + tripHours + '\'' +
                '}';
    }
}
