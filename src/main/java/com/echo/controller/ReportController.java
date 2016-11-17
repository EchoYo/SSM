package com.echo.controller;

import com.echo.model.EmpRec;
import com.echo.model.HrReport;
import com.echo.model.RecordPagePo;
import com.echo.mySqlMapper.EmpMapper;
import com.echo.mySqlMapper.HrReportMapper;
import com.echo.service.RecordService;
import com.echo.util.FindDates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-08-29.
 */
@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private RecordService recordService;

    @Autowired
    private HrReportMapper hrReportMapper;

    @RequestMapping("/reportPage.do")
    public String reportPage() {
        return "hrReport/reportPage";
    }

    //考勤报表主页在职员工数据
    @RequestMapping("/nonFullyList.do")
    public String nonFullyList(ModelMap modelMap, RecordPagePo recordPagePo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (recordPagePo.getStDate().trim().length() <= 0) {
            recordPagePo.setStDate(sdf.format(new Date()));
        }
        if (recordPagePo.getEndDate().trim().length() <= 0) {
            recordPagePo.setEndDate(sdf.format(new Date()));
        }
        List<EmpRec> recs = empMapper.forReportFully(recordPagePo);
        modelMap.addAttribute("empRecs", recs);
        return "hrReport/nonFullyList";
    }

    //准备报表处理页面数据
    @RequestMapping("/reportFully.do")
    public String reportFully(ModelMap modelMap) {
        RecordPagePo recordPagePo = new RecordPagePo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        recordPagePo.setStDate(sdf.format(new Date()));
        //准备员工数据
        List<EmpRec> recs = empMapper.forReportFully(recordPagePo);
        modelMap.addAttribute("empRecs", recs);
        return "hrReport/reportFully";
    }

    @RequestMapping("/reportOfMonthList.do")
    public String reportOfMonthList() {
        return "hrReport/reportMonth";
    }

    //月考勤表
    @RequestMapping("/monthTable.do")
    public String monthTable(ModelMap modelMap, RecordPagePo recordPagePo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (recordPagePo.getStDate().trim().length() <= 0) {
            recordPagePo.setStDate(sdf.format(new Date()));
        }
        if (recordPagePo.getEndDate().trim().length() <= 0) {
            recordPagePo.setEndDate(sdf.format(new Date()));
        }
        //准备统计信息
        List<HrReport> reports = hrReportMapper.getMonthReport(recordPagePo);
        modelMap.addAttribute("reports", reports);
        return "hrReport/monthTable";
    }

    @RequestMapping("/reportOfDaysList.do")
    public String reportOfDaysList() {
        return "hrReport/reportDate";
    }

    @RequestMapping("/dateTable.do")
    public String dateTable(ModelMap modelMap, RecordPagePo recordPagePo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (recordPagePo.getStDate().trim().length() <= 0) {
            recordPagePo.setStDate(sdf.format(new Date()));
        }
        if (recordPagePo.getEndDate().trim().length() <= 0) {
            recordPagePo.setEndDate(sdf.format(new Date()));
        }
        List<HrReport> reports = hrReportMapper.getByPo(recordPagePo);
        modelMap.addAttribute("reports", reports);
        return "hrReport/dateTable";
    }

    //考勤处理
    @RequestMapping("/disposeData.do")
    @ResponseBody
    public boolean disposeData(@RequestParam("empIds[]") List<String> empIds, String stDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (stDate.trim().length() <= 0) {
            stDate = sdf.format(new Date());
        }
        if (endDate.trim().length() <= 0) {
            endDate = sdf.format(new Date());
        }
        return recordService.disposeData(empIds, stDate, endDate);
    }

    //重新处理
    @RequestMapping("/resetData.do")
    @ResponseBody
    public boolean resetData(@RequestParam("empIds[]") List<String> empIds, String stDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (stDate.trim().length() <= 0) {
            stDate = sdf.format(new Date());
        }
        if (endDate.trim().length() <= 0) {
            endDate = sdf.format(new Date());
        }
        return recordService.resetData(empIds, stDate, endDate);
    }

    @RequestMapping("/deleteData.do")
    @ResponseBody
    public boolean deleteData(@RequestParam("empIds[]") List<String> empIds, String stDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (stDate.trim().length() <= 0) {
            stDate = sdf.format(new Date());
        }
        if (endDate.trim().length() <= 0) {
            endDate = sdf.format(new Date());
        }
        //计算出时间段
        List<String> recDates = FindDates.findDates(stDate, endDate);
        for (int i = 0; i < empIds.size(); i++) {
            for (int j = 0; j < recDates.size(); j++) {
                hrReportMapper.delete(empIds.get(i), recDates.get(j));
            }
        }
        return true;
    }

    //调班页面
    @RequestMapping("/changeShift.do")
    public String changeShift(ModelMap modelMap) {
        //准备员工数据
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String month = sdf.format(new Date());
        //查询在职员工信息不包含无指纹的
        List<EmpRec> recs = empMapper.getForOver(month);
        modelMap.addAttribute("empRecs", recs);
        return "hrChangeShift/changeShift";
    }

}
