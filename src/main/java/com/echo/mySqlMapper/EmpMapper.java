package com.echo.mySqlMapper;


import com.echo.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-06-25.
 */
@Repository
public interface EmpMapper {
    /**
     * 添加员工信息
     * @param emp
     */
    void add(Emp emp);

    /**
     * 根据信息查询员工
     * @param emp
     * @return
     */
    Emp getEmp(Emp emp);

    /**
     * 查询所有员工
     * @return
     */
    List<Emp> findAll();

    /**
     * 修改员工信息
     * @param emp
     */
    void update(Emp emp);

    /**
     * 删除员工信息
     * @param emp
     */
    void delete(Emp emp);

    /**
     * 查找在职员工档案信息
     * @return
     */
    List<EmpCustom> findListCustom();

    /**
     * 查找离职员工档案
     * @return
     */
    List<EmpCustom> findLeaveCustom();

    /**
     * 查询所有在职员工和离职日期在当前月的员工
     * 月考勤汇总
     * @param recordPagePo
     * @return
     */
    List<EmpCustom> LeaveCustomOfMonth(RecordPagePo recordPagePo);

    /**
     * 查询所有在职员工和离职日期在当前月时间段的员工
     * 天刷卡汇总
     * @param recordPagePo
     * @return
     */
    List<HrRecordCustom> RecordCustomOfDate(RecordPagePo recordPagePo);

    /**
     * 找出最大empId的值
     * @return
     */
    String getMaxEmpId();

    /**
     * 批量导入花名册
     * @param list
     */
    void addTrain(List<Emp> list);

    /**
     * 返回修改页面的包装类
     * @param empId
     * @return
     */
    EmpCustom getEmpCustom(String empId);

    /**
     * 查询所有在职员工以及离职日期小于当前日期的员工信息
     * 增加打卡刷卡记录用
     * @param stDate
     * @param endDate
     * @return
     */
    List<EmpRec> getEmpRec(String stDate,String endDate);

    /**
     * 查询所有在职员工及离职日期在month内的员工信息
     * @param recordPagePo
     * @return
     */
    List<EmpRec> forReportFully(RecordPagePo recordPagePo);
    /**
     * 查询所有在职员工及离职日期在month内的员工信息
     * 设置默认班次用
     * @param month
     * @return
     */
    List<HrRecShiftVo> getEmpForShift(String month);

    /**
     * 查询所有在职员工及离职日期在month内的员工信息
     * 月排班记录用
     * @param recordPagePo
     * @return
     */
    List<HrRecShiftCustom> getRecShiftCustom(RecordPagePo recordPagePo);

    /**
     * 查询信息给报表用
     * @param empId
     * @return
     */
    EmpTempForReport getForReport(String empId);

    /**
     * 导出excel
     * @return
     */
    List<Emp> EmpForDownLoad(String leaveYN);

    /**
     * 批量添加加班单页面员工数据
     */
    List<EmpRec> getForOver(String month);

}
