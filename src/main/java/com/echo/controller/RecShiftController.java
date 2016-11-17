package com.echo.controller;

import com.echo.model.HrRecShiftCustom;
import com.echo.model.HrShift;
import com.echo.model.RecordPagePo;
import com.echo.mySqlMapper.HrRecShiftMapper;
import com.echo.service.ShiftService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-08-09.
 */
@Controller
@RequestMapping("/shift")
public class RecShiftController {
    @Resource
    private HrRecShiftMapper hrRecShiftMapper;
    @Resource
    private ShiftService shiftService;

    @RequestMapping("/viewOfMonth.do")
    public String viewOfMonth(){
        return "hrRecShift/viewOfMonth";
    }

    //添加默认班次
    @RequestMapping("/addDefaultShift.do")
    @ResponseBody
    public Map<String, Object> addDefaultShift(String month){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        if (month == null || month.trim().length() <= 0) {
            month = sdf.format(new Date());
        }
        boolean b = shiftService.addDefaultShift(month);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("result",b);
        return map;
    }

    //按条件查询排班记录
    @RequestMapping("/getShiftOfMonth.do")
    public String getShiftOfMonth(RecordPagePo recordPagePo,ModelMap modelMap){
        //计算month的总天数，当month是空值的时候month设置为当前月份
        String month = recordPagePo.getMonth();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        if (month.trim().length() <= 0) {
            month = sdf.format(new Date());
            recordPagePo.setMonth(month);
        }
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(month));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int days = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        List<Integer> listDay = new ArrayList<Integer>();
        for (int i = 1; i <= days; i++) {
            listDay.add(i);
        }
        List<HrRecShiftCustom> hrRecShiftCustoms = shiftService.getShiftOfMonth(recordPagePo);
        //准备班次信息
        List<HrShift> shifts = hrRecShiftMapper.getAllShift();
        modelMap.addAttribute("shifts",shifts);
        modelMap.addAttribute("customs",hrRecShiftCustoms);
        modelMap.addAttribute("listDay", listDay);
        modelMap.addAttribute("month",month);
        return "hrRecShift/listShiftOfMonth";
    }

    //批量修改排班记录
    @RequestMapping("/batchUpdateShift.do")
    @ResponseBody
    public boolean batchUpdateShift(@RequestParam("empIds[]") List<String> empIds,String stDate,String endDate,String shiftId){
        return shiftService.updateList(empIds, stDate, endDate, shiftId);
    }
}
