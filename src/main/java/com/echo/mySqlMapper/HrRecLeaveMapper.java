package com.echo.mySqlMapper;

import com.echo.model.HrChangeShiftPo;
import com.echo.model.HrRecLeave;
import com.echo.model.HrRecLeaveCustom;
import com.echo.model.RecordPagePo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description:请假单</p>
 * Created by Echoj on 2016-08-16.
 */
@Repository
public interface HrRecLeaveMapper {

    List<HrRecLeaveCustom> getByPo(RecordPagePo recordPagePo);

    void add(HrRecLeave hrRecLeave);

    void update(HrRecLeave hrRecLeave);

    void delete(int id);

    HrRecLeaveCustom getById(int id);

    //查询有没有请假单
    Integer hasLeave (String empId,String recDate);

    //查询有没有调休单
    Integer hasDaysOff (String empId,String recDate);
    //查询请假单据
    List<HrRecLeave> getByIdAndDate(String empId,String recDate);
    //添加调休单
    void saveChangeShifts(HrChangeShiftPo hrChangeShiftPo);
}
