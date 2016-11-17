package com.echo.mySqlMapper;

import com.echo.model.HrHoliday;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-08-23.
 */
@Repository
public interface HrHolidayMapper {

    Integer count(String month);

    Integer inHoliday(String date);

    List<HrHoliday> getHolidays(String month);
}
