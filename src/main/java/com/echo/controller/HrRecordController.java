package com.echo.controller;

import com.echo.model.*;
import com.echo.mySqlMapper.EmpMapper;
import com.echo.mySqlMapper.HrRecordMapper;
import com.echo.service.RecordService;
import com.echo.util.ExportRecordOfMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-07-11.
 */
@Controller
@RequestMapping("/record")
public class HrRecordController {
    @Autowired
    private RecordService recordService;
    @Autowired
    private HrRecordMapper hrRecordMapper;
    @Autowired
    private EmpMapper empMapper;

    //导入原始打卡数据
    @RequestMapping("/addRawData.do")
    public
    @ResponseBody
    Map<String, Object> addRawData() {
        boolean n = recordService.addRawData();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", n);
        return map;
    }

    //获取有考勤的月份
    @RequestMapping("/getMonths.do")
    @ResponseBody
    public Map<String, Object> getMonths() {
        List<String> months = hrRecordMapper.getMonths();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("months", months);
        return map;
    }

    @RequestMapping("/list.do")
    public String list() {
        return "hrRecord/viewOfDays";
    }

    @RequestMapping("/viewOfMonth.do")
    public String listOfMonth() {
        return "hrRecord/viewOfMonth";
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public boolean add(HrRecord hrRecord,HttpSession session) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String operDate = sdf.format(new Date());
        String operId = (String) session.getAttribute("accountId");
        hrRecord.setOperId(operId);
        hrRecord.setOperDate(operDate);
        hrRecordMapper.add(hrRecord);
        return true;
    }

    @RequestMapping("/addUI.do")
    public String addUI() {
        return "hrRecord/saveUI";
    }


    //月考勤统计
    @RequestMapping("/recordOfMonth.do")
    public String recordOfMonth(RecordPagePo recordPagePo, ModelMap map, HttpSession httpSession) {
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
        List<EmpCustom> customs = recordService.findMonthOfData(recordPagePo);
        List<Integer> listDay = new ArrayList<Integer>();
        for (int i = 1; i <= days; i++) {
            listDay.add(i);
        }
        //把数据存入session中方便导出用
        httpSession.setAttribute("customs", customs);
        httpSession.setAttribute("listDay", listDay);
        map.addAttribute("customs", customs);
        map.addAttribute("listDay", listDay);
        map.addAttribute("month",month);
        return "hrRecord/listOfMonth";
    }

    //月考勤统计session失效
    @RequestMapping("/restSession.do")
    @ResponseBody
    public Map<String, Object> restSession(HttpSession httpSession) {
        httpSession.setAttribute("customs", "");
        httpSession.setAttribute("listDay", "");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", "处理成功！");
        return map;
    }

    //天刷卡汇总
    @RequestMapping("/recordOfDays.do")
    public String recordOfDays(RecordPagePo recordPagePo, ModelMap modelMap) {
        String stDate = recordPagePo.getStDate();
        String endDate = recordPagePo.getEndDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        String n = sdf.format(now);
        if ("".equals(stDate) || "".equals(endDate)) {
            recordPagePo.setStDate(n);
            recordPagePo.setEndDate(n);
        }
        List<HrRecordCustom> recordCustoms = recordService.findDaysOfData(recordPagePo);
        modelMap.addAttribute("recordCustoms", recordCustoms);
        return "hrRecord/listOfDay";
    }

    //导出月考勤记录
    @RequestMapping("/exportRecordOfMonth.do")
    public
    @ResponseBody
    Map<String, Object> exportRecordOfMonth(HttpSession session) {
        List<EmpCustom> customs = (List<EmpCustom>) session.getAttribute("customs");
        List<Integer> listDay = (List<Integer>) session.getAttribute("listDay");
        //得到当前用户的桌面路径
        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
        String desktopPath = desktopDir.getAbsolutePath();
        String expFilePath = desktopPath + "//月考勤数据.xlsx";
        ExportRecordOfMonth.expExcel(expFilePath, customs, listDay);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", "导出成功！");
        return map;
    }

    //添加刷卡记录
    @RequestMapping("/addRecTime.do")
    @ResponseBody
    public Map<String, Object> addRecTime(HrRecord hrRecord,HttpSession httpSession){
        //先确认打卡数据是不是一样 不一样的自动导入
        recordService.addRawData();
        //再添加刷卡记录
        hrRecord.setEquNo("000");
        String operId = (String) httpSession.getAttribute("accountId");
        SimpleDateFormat sfg = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String operDate = sfg.format(new Date());
        hrRecord.setOperId(operId);
        hrRecord.setOperDate(operDate);
        return recordService.addRecordTime(hrRecord);
    }

    //删除刷卡记录
    @RequestMapping("/deleteRecTime.do")
    public String deleteRecTime(int id){
        //先确认打卡数据是不是一样 不一样的自动导入
        recordService.deleteRecordTime(id);
        return "hrRecord/listRecTimes";
    }

    //转到补签卡管理页面
    @RequestMapping("/recTimesPage.do")
    public String listRecordTime(){
        return "hrRecord/recTimesPage";
    }

    //按条件查询补签卡记录
    @RequestMapping("/getRecTimes.do")
    public String getRecTimes(RecordPagePo recordPagePo,ModelMap modelMap){
        if(recordPagePo.getMonth() == null || recordPagePo.getMonth().trim().length() <= 0){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            recordPagePo.setMonth(sdf.format(new Date()));
        }
        List<HrRecordCustom> recordCustoms = hrRecordMapper.getRecTimesOfMonth(recordPagePo);
        modelMap.addAttribute("recordCustoms",recordCustoms);
        return "hrRecord/listRecTimes";
    }

    @RequestMapping("/getRecTimesForPage.do")
    public String getRecTimesForPage(ModelMap modelMap){
        RecordPagePo recordPagePo = new RecordPagePo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        recordPagePo.setMonth(sdf.format(new Date()));
        List<HrRecordCustom> recordCustoms = hrRecordMapper.getRecTimesOfMonth(recordPagePo);
        modelMap.addAttribute("recordCustoms",recordCustoms);
        return "hrRecord/listRecTimes";
    }

    //补签卡页面
    @RequestMapping("/saveRecTimeUI.do")
    public String saveRecTimeUI(ModelMap modelMap){
        //准备员工数据
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        String endDate = sdf.format(c.getTime());
        c.add(Calendar.MONTH,-2);
        String stDate = sdf.format(c.getTime());
        List<EmpRec> empRecs = empMapper.getEmpRec(stDate,endDate);
        modelMap.addAttribute("empRecs",empRecs);
        return "hrRecord/saveRecTimeUI";
    }
}
