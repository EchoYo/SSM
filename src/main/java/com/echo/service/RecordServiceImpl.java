package com.echo.service;


import com.echo.hrSqlMapper.AtdRecordMapper;
import com.echo.model.*;
import com.echo.mySqlMapper.*;
import com.echo.util.FindDates;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-07-11.
 */
@Service
public class RecordServiceImpl implements RecordService {
    @Resource
    private HrRecordMapper hrRecordMapper;
    @Resource
    private AtdRecordMapper atdRecordMapper;
    @Resource
    private EmpMapper empMapper;
    @Resource
    private HrHolidayMapper hrHolidayMapper;
    @Resource
    private HrRecShiftMapper hrRecShiftMapper;
    @Resource
    private HrShiftSectMapper hrShiftSectMapper;
    @Resource
    private HrRecLeaveMapper hrRecLeaveMapper;
    @Resource
    private HrRecOverMapper hrRecOverMapper;
    @Resource
    private HrReportMapper hrReportMapper;
    @Resource
    private HrResultTypeMapper hrResultTypeMapper;

    /**
     * 从sql数据库获取原始打卡数据存入mysql数据库
     */
    @Transactional
    public boolean addRawData() {
        //查询源数据库最大id
        int endId = atdRecordMapper.findMaxId();
        //查询mysql数据库最大id
        int maxIdOfMySql = hrRecordMapper.finMaxId();
        if (endId == maxIdOfMySql) {
            return false;
        } else {
            int stId = maxIdOfMySql + 1;
            //查询没导入的原始打卡记录并且导入到mysql数据库
            List<HrRecord> list = atdRecordMapper.getNewDatas(stId, endId);
            for (Iterator<HrRecord> it = list.iterator(); it.hasNext(); ) {
                hrRecordMapper.add(it.next());
            }
            return true;
        }
    }

    @Override
    /**
     * 考勤处理
     */
    public boolean disposeData(List<String> empIds, String stDate, String endDate) {
        String dateTemp = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String month = stDate.substring(0, 7);
        Calendar calendar = Calendar.getInstance();
        String sportStTime = null;
        String sportEndTime = null;
        String resultType = null;
        String resultName = null;
        String hours = null;
        int dayOfWeek = 0;
        int hasHoliday = 0;
        int hasDaysOff = 0;
        //处理类型
        int dayOfResult = 0;
        //根据month查询本月有没有节日
        hasHoliday = hrHolidayMapper.count(month);
        List<HrHoliday> holidays = new ArrayList<HrHoliday>();
        //算出日期段
        List<String> recDates = FindDates.findDates(stDate, endDate);
        //根据日期算出处理类型 1平时 2公休 3节日
        List<Integer> recDatesResult = new ArrayList<Integer>();
        //根据日期算出对应的考勤类型 （有国假和无国假两种情况）
        if (hasHoliday != 0) { //有国假
            for (String recDate : recDates) {
                if (hrHolidayMapper.inHoliday(recDate) == 0) { //不在节日内
                    //先判断是不是周六周日 result = 2
                    try {
                        calendar.setTime(sdf.parse(recDate));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                    if (dayOfWeek == 1 || dayOfWeek == 7) {
                        recDatesResult.add(2); //周末
                    } else {
                        recDatesResult.add(1);//平时
                    }
                } else {
                    recDatesResult.add(3);//节日
                }
            }
        } else {//无国假
            for (String recDate : recDates) {
                //判断双休
                try {
                    calendar.setTime(sdf.parse(recDate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek == 1 || dayOfWeek == 7) {
                    recDatesResult.add(2); //周末
                } else {
                    recDatesResult.add(1);//平时
                }
            }
        }
        for (String empId : empIds) {
            //根据empId查询出 姓名 部门 工号
            EmpTempForReport empTempForReport = empMapper.getForReport(empId);
            //入职日期
            String entryDate = empTempForReport.getEntryDate();
            String dateNow = null;
            //离职日期
            String leaveDate = null;
            leaveDate = empTempForReport.getLeaveDate();
            //循环日期
            for (int j = 0; j < recDates.size(); j++) {
                dateNow = recDates.get(j);
                //创建hrReport对象
                HrReport hrReport = new HrReport();
                hrReport.setEmpName(empTempForReport.getEmpName());
                hrReport.setEmpId(empId);
                hrReport.setDeptName(empTempForReport.getDeptName());
                hrReport.setWorkId(empTempForReport.getWorkId());
                hrReport.setDeptId(empTempForReport.getDeptId());
                hrReport.setRecDate(dateNow);
                //根据empId和date查询出排班信息
                HrShift hrShift = hrRecShiftMapper.getByIdAndDate(empId, dateNow);
                //添加班次名称
                hrReport.setShiftName(hrShift.getShiftName());
                //根据shiftId查询班次
                List<HrShiftSect> shiftCustoms = hrShiftSectMapper.getById(hrShift.getShiftId());
                //查询出有效打卡时间段
                String stRecTime = shiftCustoms.get(0).getStRecTime();
                String stAtdTime = shiftCustoms.get(0).getStAtdTime();
                String endAtdTime = shiftCustoms.get(0).getEndAtdTime();
                String endRecTime = shiftCustoms.get(0).getEndRecTime();
                String stAtdTime2 = shiftCustoms.get(1).getStAtdTime();
                String endAtdTime2 = shiftCustoms.get(1).getEndAtdTime();
                //根据empId和stDate查询出打卡记录
                List<String> recTimes = hrRecordMapper.getByIdAndDate(empId, dateNow);
                List<String> recTimes2 = new ArrayList<String>();
                List<HrShiftSect> shiftCustoms2 = new ArrayList<HrShiftSect>();
                String time = null;
                //判断有没有打卡记录
                if (recTimes != null) { //有打卡记录
                    //循环判断上班打卡记录
                    for (String recTime : recTimes) {
                        time = recTime;
                        //当上班卡为空的时候找出第一个正常打卡时间
                        if (hrReport.getStAtdTime() == null) {
                            //打卡时间在设置的开始打卡之后的
                            if (time.compareTo(stRecTime) > 0) {
                                hrReport.setStAtdTime(time); //上班打卡时间
                            }
                        } else {
                            //有上班卡就存到下班里面 (必须是大于上班时间的卡才存入下班卡)
                            if (time.compareTo(stAtdTime) > 0) {
                                hrReport.setEndAtdTime(time);
                            }

                        }
                    }
                    //判断上下班卡是否打到第二天(不为最后一天的情况)
                    if (j + 1 < recDates.size()) {
                        //根据empId和date查询出排班信息
                        HrShift hrShift2 = hrRecShiftMapper.getByIdAndDate(empId, recDates.get(j + 1));
                        //根据shiftId查询班段
                        shiftCustoms2 = hrShiftSectMapper.getById(hrShift2.getShiftId());
                        //查询出有效打卡时间段
                        String stRecTime2 = shiftCustoms2.get(0).getStRecTime();
                        //根据empId和stDate +1查询出打卡记录
                        recTimes2 = hrRecordMapper.getByIdAndDate(empId, recDates.get(j + 1));
                        //当打卡记录不为空的时候判断
                        if (recTimes2 != null) {
                            for (String time2 : recTimes2) {
                                //在正常班之前的打卡记录
                                if (time2.compareTo(stRecTime2) < 0) {
                                    //判断当没有上班卡，是不是在第二班段内（夜班）
                                    if (hrReport.getStAtdTime() == null && time2.compareTo(endAtdTime) < 0) {
                                        //添加上班卡
                                        hrReport.setStAtdTime(time2);
                                    } else {
                                        //添加下班卡
                                        hrReport.setEndAtdTime(time2);
                                    }
                                }
                            }
                        }
                    } else {  //当月最后一天
                        Date d = null;
                        try {
                            d = sdf.parse(dateNow);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        assert d != null;
                        calendar.setTime(d);
                        calendar.add(Calendar.DAY_OF_YEAR, 1);
                        d = calendar.getTime();
                        //下个月的第一天
                        dateTemp = sdf.format(d);
                        //根据empId和date查询出排班信息
                        HrShift hrShift2 = hrRecShiftMapper.getByIdAndDate(empId, dateTemp);
                        //根据shiftId查询班段
                        shiftCustoms2 = hrShiftSectMapper.getById(hrShift.getShiftId());
                        //查询出有效打卡时间段
                        String stRecTime2 = shiftCustoms2.get(0).getStRecTime();
                        //根据empId和当前日期查询出打卡记录
                        recTimes2 = hrRecordMapper.getByIdAndDate(empId, dateTemp);
                        //当打卡记录不为空的时候判断
                        if (recTimes2 != null) {
                            for (String time2 : recTimes2) {
                                //在正常班之前的打卡记录
                                if (time2.compareTo(stRecTime2) < 0) {
                                    //判断当没有上班卡是不是在第二班段内
                                    if (hrReport.getStAtdTime() == null && time2.compareTo(endAtdTime) < 0) {
                                        //添加上班卡
                                        hrReport.setStAtdTime(time2);
                                    } else {
                                        //添加下班卡
                                        hrReport.setEndAtdTime(time2);
                                    }
                                }
                            }
                        }
                    }
                }
                //上下班打卡处理完毕，根据处理类型计算
                sportStTime = hrReport.getStAtdTime();
                sportEndTime = hrReport.getEndAtdTime();
                //查出今天的考勤类型
                dayOfResult = recDatesResult.get(j);
                //查找有没有请假单
                List<HrRecLeave> hrRecLeave = new ArrayList<HrRecLeave>();
                hrRecLeave = hrRecLeaveMapper.getByIdAndDate(empId, dateNow);
                //查询有没有调休单
                hasDaysOff = hrRecLeaveMapper.hasDaysOff(empId, dateNow);
                //有调休
                if (hasDaysOff != 0) {
                    if (dayOfResult == 1) {
                        dayOfResult = 2;
                    } else if (dayOfResult == 2) {
                        dayOfResult = 1;
                    }
                }
                //上下班卡为空的情况
                if (sportStTime == null || sportEndTime == null) {
                    dateNow = recDates.get(j);
                    if (dayOfResult == 1) {   //正常班
                        //应出勤1天
                        hrReport.setyChuQin("8.0");
                        //判断有没有离职
                        if (leaveDate != null && (leaveDate.length() > 0 && 0 <= dateNow.compareTo(leaveDate))) {
                            hrReport.setResultName("离职");
                        } else {
                            //有请假单
                            if (hrRecLeave != null) {
                                //判断是一个请假单还是两个 两个请假单另外一个就是哺乳假单
                                if(hrRecLeave.size() < 2){
                                    resultType = hrRecLeave.get(0).getResultType();
                                    hrReport.setResultType(resultType);
                                    resultName = hrResultTypeMapper.getByType(resultType);
                                    hrReport.setResultName(resultName);
                                    hours = hrRecLeave.get(0).getHours();
                                }else{
                                    //有多张单子就把哺乳假剔除
                                    for(int i=0;i<hrRecLeave.size();i++){
                                        String r = hrRecLeave.get(i).getResultType();
                                        //不是哺乳假单
                                        if(!"0407".equals(r)){
                                            resultType = r;
                                            hours = hrRecLeave.get(i).getHours();
                                            break;
                                        }
                                    }
                                    hrReport.setResultType(resultType);
                                    resultName = hrResultTypeMapper.getByType(resultType);
                                    hrReport.setResultName(resultName);
                                }
                                //请假类型 无薪假
                                if ("0401".equals(resultType)) {
                                    //请假工时
                                    hrReport.setLeaveHours("8.0");
                                } else if ("0402".equals(resultType)) {
                                    //病假
                                    hrReport.setSalaryResult("2");
                                    //请假工时
                                    hrReport.setLeaveHours("8.0");
                                } else if ("0403".equals(resultType) || "0404".equals(resultType)
                                        || "0405".equals(resultType) || "0406".equals(resultType)) {
                                    //有薪假
                                    hrReport.setSalaryResult("1");
                                    //实际出勤
                                    hrReport.setsChuQin("8.0");
                                    //请假时间
                                    hrReport.setLeaveHours("8.0");
                                } else if ("0501".equals(resultType)) {
                                    //有薪假
                                    hrReport.setSalaryResult("1");
                                    //实际出勤
                                    hrReport.setsChuQin("8.0");
                                    //出差工时
                                    hrReport.setTripHours("8.0");
                                }
                            } else {
                                //入职日期在今天以后的算旷工
                                if (dateNow.compareTo(entryDate) >= 0) {
                                    //在入职之前
                                    hrReport.setKuangGong("8.0");
                                }
                            }
                        }
                    } else if (dayOfResult == 3) {
                        //节日的情况 判断入职和离职
                        holidays = hrHolidayMapper.getHolidays(month);
                        for (HrHoliday hrHoliday : holidays) {
                            //离职情况
                            if (leaveDate != null && leaveDate.length() > 0) {
                                //入职在节日之前并且离职再节日之后算节日出勤
                                if (entryDate.compareTo(hrHoliday.getStartDate()) < 0 && leaveDate.compareTo(hrHoliday.getEndDate()) > 0) {
                                    hrReport.setsJieRi("8.0");
                                }
                            } else {
                                //没有离职 入职日期小于节日日期算节日出勤
                                if (entryDate.compareTo(hrHoliday.getStartDate()) < 0) {
                                    hrReport.setsJieRi("8.0");
                                }
                            }
                        }
                    }
                } else {
                    //上下班打卡记录都有  查找加班单加班时间
                    String overHours = hrRecOverMapper.getOverHours(empId, dateNow);
                    switch (dayOfResult) {
                        //正常班
                        case 1:
                            //应出勤1天
                            hrReport.setyChuQin("8.0");
                            if (overHours != null) {
                                //添加平时加班
                                hrReport.setPs(overHours);
                            }
                            //第二班段时间大于第一班段时间的情况
                            if (endAtdTime2.compareTo(endAtdTime) > 0) {
                                //迟到 早退
                                if ((sportStTime.compareTo(stAtdTime) > 0) || (sportEndTime.compareTo(endAtdTime2) < 0
                                        && sportEndTime.compareTo(endAtdTime) > 0)) {
                                    //有请假单
                                    if (hrRecLeave != null) {
                                        //判断是一个请假单还是两个 两个请假单另外一个就是哺乳假单
                                        if(hrRecLeave.size() < 2){
                                            resultType = hrRecLeave.get(0).getResultType();
                                            hrReport.setResultType(resultType);
                                            resultName = hrResultTypeMapper.getByType(resultType);
                                            hrReport.setResultName(resultName);
                                            hours = hrRecLeave.get(0).getHours();
                                        }else{
                                            //有多张单子就把哺乳假剔除
                                            for(int i=0;i<hrRecLeave.size();i++){
                                                String r = hrRecLeave.get(i).getResultType();
                                                //不是哺乳假单
                                                if(!"0407".equals(r)){
                                                    resultType = r;
                                                    hours = hrRecLeave.get(i).getHours();
                                                    break;
                                                }
                                            }
                                            hrReport.setResultType(resultType);
                                            resultName = hrResultTypeMapper.getByType(resultType);
                                            hrReport.setResultName(resultName);
                                        }
                                        //请假类型 无薪假
                                        if ("0401".equals(resultType)) {
                                            //请假工时
                                            hrReport.setLeaveHours(hours);
                                            double b = 0.0;
                                            b = 8.0 - Double.parseDouble(hours);
                                            hrReport.setsChuQin(String.valueOf(b));
                                        } else if ("0407".equals(resultType) || "0403".equals(resultType)) {
                                            //哺乳假 年假 有薪假
                                            hrReport.setSalaryResult("1");
                                            //实际出勤
                                            hrReport.setsChuQin("8.0");
                                            //请假工时
                                            hrReport.setLeaveHours(hours);
                                        } else if ("0501".equals(resultType)) {
                                            //有薪假
                                            hrReport.setSalaryResult("1");
                                            //实际出勤
                                            hrReport.setsChuQin("8.0");
                                            //出差工时
                                            hrReport.setTripHours("8.0");
                                        }
                                    } else {  //没请假单
                                        //迟到  计算迟到分钟数
                                        if (sportStTime.compareTo(stAtdTime) > 0) {
                                            int t11 = Integer.parseInt(stAtdTime.substring(0, 2));
                                            int t12 = Integer.parseInt(stAtdTime.substring(3));
                                            int t21 = Integer.parseInt(sportStTime.substring(0, 2));
                                            int t22 = Integer.parseInt(sportStTime.substring(3));
                                            long t1 = t11 * 60 * 60 * 1000 + t12 * 60 * 1000;
                                            long t2 = t21 * 60 * 60 * 1000 + t22 * 60 * 1000;
                                            long minute = (t2 - t1) / 1000 / 60 % 60;
                                            //判断迟到分钟数小于30算迟到 大于三十算旷工
                                            if (minute < 30) {
                                                hrReport.setLate("1.0");
                                                hrReport.setLateMinutes(String.valueOf(minute));
                                                hrReport.setsChuQin("7.5");
                                            } else {
                                                hrReport.setKuangGong("8.0");
                                            }
                                        }
                                        //早退  计算早退分钟数
                                        if (sportEndTime.compareTo(endAtdTime2) < 0) {
                                            int t11 = Integer.parseInt(endAtdTime2.substring(0, 2));
                                            int t12 = Integer.parseInt(endAtdTime2.substring(3));
                                            int t21 = Integer.parseInt(sportEndTime.substring(0, 2));
                                            int t22 = Integer.parseInt(sportEndTime.substring(3));
                                            long t2 = t11 * 60 * 60 * 1000 + t12 * 60 * 1000;
                                            long t1 = t21 * 60 * 60 * 1000 + t22 * 60 * 1000;
                                            long minute = (t2 - t1) / 1000 / 60 % 60;
                                            //判断迟到分钟数小于30算迟到 大于三十算旷工
                                            if (minute < 30) {
                                                hrReport.setEarly("1.0");
                                                hrReport.setEarlyMinutes(String.valueOf(minute));
                                                hrReport.setsChuQin("7.5");
                                            } else {
                                                hrReport.setKuangGong("8.0");
                                            }
                                        }
                                    }
                                } else {
                                    //判断上班中途请假（上下班打卡正常）
                                    if (hrRecLeave != null) {
                                        //判断是一个请假单还是两个 两个请假单另外一个就是哺乳假单
                                        if(hrRecLeave.size() < 2){
                                            resultType = hrRecLeave.get(0).getResultType();
                                            hrReport.setResultType(resultType);
                                            resultName = hrResultTypeMapper.getByType(resultType);
                                            hrReport.setResultName(resultName);
                                            hours = hrRecLeave.get(0).getHours();
                                        }else{
                                            //有多张单子就把哺乳假剔除
                                            for(int i=0;i<hrRecLeave.size();i++){
                                                String r = hrRecLeave.get(i).getResultType();
                                                //不是哺乳假单
                                                if(!"0407".equals(r)){
                                                    resultType = r;
                                                    hours = hrRecLeave.get(i).getHours();
                                                    break;
                                                }
                                            }
                                            hrReport.setResultType(resultType);
                                            resultName = hrResultTypeMapper.getByType(resultType);
                                            hrReport.setResultName(resultName);
                                        }
                                        //请假类型 无薪假
                                        if ("0401".equals(resultType)) {
                                            //请假工时
                                            hrReport.setLeaveHours(hours);
                                            double b = 0.0;
                                            b = 8.0 - Double.parseDouble(hours);
                                            hrReport.setsChuQin(String.valueOf(b));
                                        } else if ("0407".equals(resultType) || "0403".equals(resultType)) {
                                            //哺乳假 年假 有薪假
                                            hrReport.setSalaryResult("1");
                                            //实际出勤
                                            hrReport.setsChuQin("8.0");
                                            //请假工时
                                            hrReport.setLeaveHours(hours);
                                        }
                                    } else {
                                        //正常打卡
                                        hrReport.setsChuQin("8.0");
                                    }
                                }
                            } else {  //第二班段小于第一班段
                                //迟到 早退 旷工
                                if (sportStTime.compareTo(stAtdTime) > 0 || sportStTime.compareTo(endAtdTime2) < 0 ||
                                        sportEndTime.compareTo(stAtdTime) > 0 || sportEndTime.compareTo(endAtdTime2) < 0) {
                                    //有请假单
                                    if (hrRecLeave != null) {
                                        //判断是一个请假单还是两个 两个请假单另外一个就是哺乳假单
                                        if(hrRecLeave.size() < 2){
                                            resultType = hrRecLeave.get(0).getResultType();
                                            hrReport.setResultType(resultType);
                                            resultName = hrResultTypeMapper.getByType(resultType);
                                            hrReport.setResultName(resultName);
                                            hours = hrRecLeave.get(0).getHours();
                                        }else{
                                            //有多张单子就把哺乳假剔除
                                            for(int i=0;i<hrRecLeave.size();i++){
                                                String r = hrRecLeave.get(i).getResultType();
                                                //不是哺乳假单
                                                if(!"0407".equals(r)){
                                                    resultType = r;
                                                    hours = hrRecLeave.get(i).getHours();
                                                    break;
                                                }
                                            }
                                            hrReport.setResultType(resultType);
                                            resultName = hrResultTypeMapper.getByType(resultType);
                                            hrReport.setResultName(resultName);
                                        }
                                        //请假类型 无薪假
                                        if ("0401".equals(resultType)) {
                                            //请假工时
                                            hrReport.setLeaveHours(hours);
                                        } else if ("0407".equals(resultType) || "0403".equals(resultType)) {
                                            //哺乳假 年假 有薪假
                                            hrReport.setSalaryResult("1");
                                            //实际出勤
                                            hrReport.setsChuQin("1.0");
                                            //请假工时
                                            hrReport.setLeaveHours(hours);
                                        } else if ("0501".equals(resultType)) {
                                            //有薪假
                                            hrReport.setSalaryResult("1");
                                            //实际出勤
                                            hrReport.setsChuQin("1.0");
                                            //出差工时
                                            hrReport.setTripHours("8.0");
                                        }
                                    } else {  //没请假单
                                        //上班卡在第二时间段 或者下班卡在第一时间段  旷工
                                        if (sportStTime.compareTo(stAtdTime2) > 0 || sportEndTime.compareTo(stAtdTime) > 0) {
                                            //旷工
                                            hrReport.setKuangGong("8.0");
                                        } else {
                                            //迟到  计算迟到分钟数
                                            if (sportStTime.compareTo(stAtdTime) > 0) {
                                                int t11 = Integer.parseInt(stAtdTime.substring(0, 2));
                                                int t12 = Integer.parseInt(stAtdTime.substring(3));
                                                int t21 = Integer.parseInt(sportStTime.substring(0, 2));
                                                int t22 = Integer.parseInt(sportStTime.substring(3));
                                                long t1 = t11 * 60 * 60 * 1000 + t12 * 60 * 1000;
                                                long t2 = t21 * 60 * 60 * 1000 + t22 * 60 * 1000;
                                                long minute = (t2 - t1) / 1000 / 60 % 60;
                                                //判断迟到分钟数小于30算迟到 大于三十算旷工
                                                if (minute < 30) {
                                                    hrReport.setLate("1.0");
                                                    hrReport.setLateMinutes(String.valueOf(minute));
                                                    hrReport.setsChuQin("7.5");
                                                } else {
                                                    hrReport.setKuangGong("8.0");
                                                }
                                            }
                                            if (sportEndTime.compareTo(endAtdTime2) < 0) {
                                                //早退  计算早退分钟数
                                                int t11 = Integer.parseInt(endAtdTime2.substring(0, 2));
                                                int t12 = Integer.parseInt(endAtdTime2.substring(3));
                                                int t21 = Integer.parseInt(sportEndTime.substring(0, 2));
                                                int t22 = Integer.parseInt(sportEndTime.substring(3));
                                                long t2 = t11 * 60 * 60 * 1000 + t12 * 60 * 1000;
                                                long t1 = t21 * 60 * 60 * 1000 + t22 * 60 * 1000;
                                                long minute = (t2 - t1) / 1000 / 60 % 60;
                                                //判断迟到分钟数小于30算迟到 大于三十算旷工
                                                if (minute < 30) {
                                                    hrReport.setEarly("1.0");
                                                    hrReport.setEarlyMinutes(String.valueOf(minute));
                                                    hrReport.setsChuQin("7.5");
                                                } else {
                                                    hrReport.setKuangGong("8.0");
                                                }
                                            }

                                        }
                                    }
                                } else {
                                    //判断上班中途请假（上下班打卡正常）
                                    if (hrRecLeave != null) {
                                        //判断是一个请假单还是两个 两个请假单另外一个就是哺乳假单
                                        if(hrRecLeave.size() < 2){
                                            resultType = hrRecLeave.get(0).getResultType();
                                            hrReport.setResultType(resultType);
                                            resultName = hrResultTypeMapper.getByType(resultType);
                                            hrReport.setResultName(resultName);
                                            hours = hrRecLeave.get(0).getHours();
                                        }else{
                                            //有多张单子就把哺乳假剔除
                                            for(int i=0;i<hrRecLeave.size();i++){
                                                String r = hrRecLeave.get(i).getResultType();
                                                //不是哺乳假单
                                                if(!"0407".equals(r)){
                                                    resultType = r;
                                                    hours = hrRecLeave.get(i).getHours();
                                                    break;
                                                }
                                            }
                                            hrReport.setResultType(resultType);
                                            resultName = hrResultTypeMapper.getByType(resultType);
                                            hrReport.setResultName(resultName);
                                        }
                                        //请假类型 无薪假
                                        if ("0401".equals(resultType)) {
                                            //请假工时
                                            hrReport.setLeaveHours(hours);
                                        } else if ("0407".equals(resultType) || "0403".equals(resultType)) {
                                            //哺乳假 年假 有薪假
                                            hrReport.setSalaryResult("1");
                                            //实际出勤
                                            hrReport.setsChuQin("8.0");
                                            //请假工时
                                            hrReport.setLeaveHours(hours);
                                        }
                                    } else {
                                        //正常打卡
                                        hrReport.setsChuQin("8.0");
                                    }
                                }
                            }
                            break;
                        //双休
                        case 2:
                            //有打卡记录 必须要有加班单才能算加班
                            if (overHours != null) {
                                //添加周末加班
                                hrReport.setGx(overHours);
                            }
                            break;
                        //节日
                        case 3:
                            hrReport.setsJieRi("8.0");
                            //有打卡记录 必须要有加班单才能算加班
                            if (overHours != null) {
                                //添加节日加班
                                hrReport.setJr(overHours);
                            }
                            break;
                    }
                }
                //判断数据库中是否有生成好的数据 有的话删除
                if (hrReportMapper.hasReport(empId, dateNow) != 0) {
                    hrReportMapper.delete(empId, dateNow);
                }
                //把hrReport写入到数据库中
                hrReportMapper.add(hrReport);
            }
        }
        return true;
    }

    @Override
    /**
     * 返回月考勤数据
     */
    public List<EmpCustom> findMonthOfData(RecordPagePo recordPagePo) {
        //查询出所有本月打卡记录的员工信息
        List<EmpCustom> customs = empMapper.LeaveCustomOfMonth(recordPagePo);
        //获取本月最大天数
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat sdfn = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(recordPagePo.getMonth()));
            c.set(Calendar.DAY_OF_MONTH, 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int days = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        //遍历根据customs信息查询对应的打卡信息
        for (EmpCustom custom : customs) {
            List<List<String>> records = new ArrayList<List<String>>();
            //循环添加每天的打卡数据
            for (int i = 1; i <= days; i++) {
                //从每月一号开始循环i
                Calendar calendar = c;
                calendar.set(Calendar.DAY_OF_MONTH, i);
                String date = sdfn.format(calendar.getTime());
                String empId = custom.getEmp().getEmpId();
                List<String> hrRecords = hrRecordMapper.getByIdAndDate(empId, date);
                records.add(hrRecords);
            }
            custom.setRecords(records);
        }
        return customs;
    }

    /**
     * 日考勤数据
     *
     * @param recordPagePo
     * @return
     */
    @Override
    public List<HrRecordCustom> findDaysOfData(RecordPagePo recordPagePo) {
        //查询当前时间段内在职员工
        List<HrRecordCustom> recordCustoms = empMapper.RecordCustomOfDate(recordPagePo);
        int recordSize = recordCustoms.size();
        //获取时间段
        String stDate = recordPagePo.getStDate();
        String endDate = recordPagePo.getEndDate();
        List<String> dates = FindDates.findDates(stDate, endDate);
        int dateSize = dates.size();
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        //计算开始时间是周几
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date s = null;
        try {
            s = sdf.parse(stDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert s != null;
        calendar.setTime(s);
        //DAY_OF_WEEK从1开始算的
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int n = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        String deptName = null;
        String workId = null;
        String empName = null;
        String dayOfWeek = null;
        //返回的完整集合
        List<HrRecordCustom> recordCustomsOfDates = new ArrayList<HrRecordCustom>();
        for (int i = 0; i < recordSize; i++) {
            HrRecordCustom recordCustom = recordCustoms.get(i);
            deptName = recordCustom.getDeptName();
            workId = recordCustom.getWorkId();
            empName = recordCustom.getEmpName();
            for (int j = 0; j < dateSize; j++) {
                List<String> recTimes = hrRecordMapper.getByIdAndDate(recordCustom.getEmpId(), dates.get(j));
                dayOfWeek = weekDays[w % 7];
                w++;
                HrRecordCustom rs = new HrRecordCustom();
                rs.setDeptName(deptName);
                rs.setEmpName(empName);
                rs.setWorkId(workId);
                rs.setDayOfWeek(dayOfWeek);
                rs.setRecDate(dates.get(j));
                if (recTimes != null) {
                    switch (recTimes.size()) {
                        case 4:
                            rs.setRecTime4(recTimes.get(3));
                        case 3:
                            rs.setRecTime3(recTimes.get(2));
                        case 2:
                            rs.setRecTime2(recTimes.get(1));
                        case 1:
                            rs.setRecTime1(recTimes.get(0));
                            break;
                    }
                }
                recordCustomsOfDates.add(rs);
            }
            w = n;
        }
        return recordCustomsOfDates;
    }

    //添加打卡记录
    @Override

    public Map<String, Object> addRecordTime(HrRecord hrRecord) {
        Map<String, Object> map = new HashMap<String, Object>();
        //先查询有没有相同的打卡记录
        List<String> recTimes = hrRecordMapper.getByIdAndDate(hrRecord.getEmpId(), hrRecord.getRecDate());
        //查出的集合中没有这个打卡数据再执行添加操作
        if (!recTimes.contains(hrRecord.getRecTime())) {
            int id = hrRecordMapper.finMaxId() + 1;
            hrRecord.setId(id);
            //添加打卡记录到mysql
            hrRecordMapper.add(hrRecord);
            //添加打卡记录到sql确保两边的主键id相同
            atdRecordMapper.add(hrRecord);
            map.put("result", "true");
        } else {
            map.put("result", "false");
        }
        return map;
    }

    //删除打卡记录
    @Override
    public void deleteRecordTime(Integer id) {
        //删除mysql打卡记录
        hrRecordMapper.delete(id);
        //删除sql打卡记录
        atdRecordMapper.delete(id);
    }

    //重新处理考勤
    @Override
    public boolean resetData(List<String> empIds, String stDate, String endDate) {
        //先删除存在的数据
        int count = 0;
        List<String> recDates = FindDates.findDates(stDate, endDate);
        for (String empId : empIds) {
            for (String recDate : recDates) {
                //查询记录为1删除
                count = hrReportMapper.hasReport(empId, recDate);
                if (count == 1) {
                    hrReportMapper.delete(empId, recDate);
                }
            }
        }
        //再重新生成
        return disposeData(empIds, stDate, endDate);
    }


}
