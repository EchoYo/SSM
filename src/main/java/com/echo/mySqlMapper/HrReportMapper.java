package com.echo.mySqlMapper;

import com.echo.model.HrReport;
import com.echo.model.RecordPagePo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description:报表</p>
 * Created by Echoj on 2016-08-27.
 */
@Repository
public interface HrReportMapper {
    //添加
    void add(HrReport hrReport);
    //按人员编号和月份删除
    void delete(String empId,String recDate);
    //按条件查询
    List<HrReport> getByPo(RecordPagePo recordPagePo);
    //月考勤
    List<HrReport> getMonthReport(RecordPagePo recordPagePo);
    //根据empId和日期查询有没有数据
    Integer hasReport(String empId,String date);
}
