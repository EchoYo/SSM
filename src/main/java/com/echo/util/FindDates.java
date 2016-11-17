package com.echo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>Description:获取时间段</p>
 * Created by Echoj on 2016-07-28.
 */
public class FindDates {
    public static List<String> findDates(String stDate, String endDate) {
        //创建时间段数组
        List<String> dates = new ArrayList<String>();
        //将开始时间添加到list中
        dates.add(stDate);
        Date dBegin = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        //判断输入的日期不相等
        while (!stDate.equals(endDate)){
            try {
                dBegin = sdf.parse(stDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //将dBegin设置成当前时间
            assert dBegin != null;
            calendar.setTime(dBegin);
            //当前时间加一天并且添加到list中
            calendar.add(Calendar.DAY_OF_YEAR,1);
            stDate = sdf.format(calendar.getTime());
            dates.add(stDate);
        }
        return dates;
    }

    public static List<String> daysOfMonth(String month){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = null;
        try {
             date = sdf.parse(month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        assert date != null;
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        String stDate = month + "-" +"01";
        String endDate = month + "-" + max;
        return findDates(stDate,endDate);
    }
}
