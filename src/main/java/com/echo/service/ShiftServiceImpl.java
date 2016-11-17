package com.echo.service;

import com.echo.model.HrRecShift;
import com.echo.model.HrRecShiftCustom;
import com.echo.model.HrRecShiftVo;
import com.echo.model.RecordPagePo;
import com.echo.mySqlMapper.EmpMapper;
import com.echo.mySqlMapper.HrRecShiftMapper;
import com.echo.util.FindDates;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-08-08.
 */
@Service
public class ShiftServiceImpl implements ShiftService {
    @Resource
    private EmpMapper empMapper;
    @Resource
    private HrRecShiftMapper hrRecShiftMapper;

    @Override
    public boolean addDefaultShift(String month) {
        //根据月份查询所有在职员工及离职日期在month内的员工信息
        List<HrRecShiftVo> hrsv = empMapper.getEmpForShift(month);
        //算出dates数组
        List<String> dates = FindDates.daysOfMonth(month);
        String empId = null;
        String shiftId = null;
        String stDate = null;
        //遍历数组根据empId判断有没有设置过默认班次
        for(HrRecShiftVo hrRecShiftVo:hrsv){
            empId = hrRecShiftVo.getEmpId();
            shiftId = hrRecShiftVo.getShiftId();
            for(int i = 0;i<dates.size();i++){
                stDate = dates.get(i);
                if(hrRecShiftMapper.count(empId,stDate) == 0){
                    HrRecShift shift = new HrRecShift();
                    shift.setEmpId(empId);
                    shift.setStDate(stDate);
                    shift.setShiftId(shiftId);
                    hrRecShiftMapper.add(shift);
                }
            }
        }
        return true;
    }

    @Override
    public boolean updateList(List<String> empIds, String stDate, String endDate, String shiftId) {
        //算出dates集合
        List<String> dates = FindDates.findDates(stDate,endDate);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("dates",dates);
        map.put("empIds",empIds);
        map.put("shiftId",shiftId);
        hrRecShiftMapper.updateList(map);
        return true;
    }

    @Override
    public List<HrRecShiftCustom> getShiftOfMonth(RecordPagePo recordPagePo) {
        String month = recordPagePo.getMonth();
        //根据条件查询在职员工
        List<HrRecShiftCustom> hrsc = empMapper.getRecShiftCustom(recordPagePo);
        //根据month算出时间段
        List<String> dates = FindDates.daysOfMonth(month);
        int s = dates.size();
        String shiftId = null;
        //循环在职员工信息根据信息查询排班记录
        for(HrRecShiftCustom custom:hrsc){
            custom.setMonth(month);
            List<String> shiftIds = new ArrayList<String>();
            for(int i = 0;i<s;i++){
                shiftId = hrRecShiftMapper.findShiftNameOfMonth(custom.getEmpId(),dates.get(i));
                shiftIds.add(shiftId);
            }
           custom.setShiftIds(shiftIds);
        }
        return hrsc;
    }

}
