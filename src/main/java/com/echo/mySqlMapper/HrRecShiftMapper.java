package com.echo.mySqlMapper;

import com.echo.model.HrRecShift;
import com.echo.model.HrShift;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>Description:排班登记表</p>
 * Created by Echoj on 2016-07-25.
 */
@Repository
public interface HrRecShiftMapper {
    void add(HrRecShift hrRecShift);

    void update(HrRecShift hrRecShift);

    void delete(HrRecShift hrRecShift);

    int count(String empId,String stDate);

    //按月份查询排班记录
    String findShiftNameOfMonth(String empId,String stDate);

    //批量更新
    void updateList(Map<String,Object> map);

    //按empId和recDate查询排班次信息
    HrShift getByIdAndDate(String empId,String stDate);

    //查询班次信息
    List<HrShift> getAllShift();
}
