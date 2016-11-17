package com.echo.service;

import com.echo.model.HrRecShiftCustom;
import com.echo.model.RecordPagePo;

import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-08-08.
 */
public interface ShiftService {
    //设置默认班次
    boolean addDefaultShift(String month);

    //批量更改班次
    boolean updateList(List<String> empIds,String stDate,String endDate,String shiftId);

    //根据条件查询月排班记录
    List<HrRecShiftCustom> getShiftOfMonth(RecordPagePo recordPagePo);

}
