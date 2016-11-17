package com.echo.service;

import com.echo.model.EmpCustom;
import com.echo.model.HrRecord;
import com.echo.model.HrRecordCustom;
import com.echo.model.RecordPagePo;

import java.util.List;
import java.util.Map;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-07-11.
 */
public interface RecordService {
    //导入原始刷卡数据
    boolean addRawData();
    //处理考勤
    boolean disposeData(List<String> empIds,String stDate,String endDate);
    //查询月考勤记录
    List<EmpCustom> findMonthOfData(RecordPagePo recordPagePo);
    //查询天刷卡汇总
    List<HrRecordCustom> findDaysOfData(RecordPagePo recordPagePo);
    //添加刷卡记录
    Map<String, Object> addRecordTime(HrRecord hrRecord);
    //删除打卡记录
    void deleteRecordTime(Integer id);
    //重新处理
    boolean resetData(List<String> empIds,String stDate,String endDate);
}
