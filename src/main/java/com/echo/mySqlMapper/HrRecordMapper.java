package com.echo.mySqlMapper;

import com.echo.model.HrRecord;
import com.echo.model.HrRecordCustom;
import com.echo.model.RecordPagePo;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * <p>Description:</p>
 * Created by Echoj on 2016-07-08.
 */
@Repository
public interface HrRecordMapper {
    void add(HrRecord record);

    void addRawList(List<HrRecord> list);

    List<HrRecord> getByDate(String date);

    List<String> getByIdAndDate(String empId,String date);

    Integer finMaxId();

    List<String> getMonths();

    void delete(Integer id);
    //查询补签卡记录
    List<HrRecordCustom> getRecTimesOfMonth(RecordPagePo recordPagePo);
}
