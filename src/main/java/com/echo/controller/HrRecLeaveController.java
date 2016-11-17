package com.echo.controller;

import com.echo.model.*;
import com.echo.mySqlMapper.EmpMapper;
import com.echo.mySqlMapper.HrRecLeaveMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>Description:请假单登记</p>
 * Created by Echoj on 2016-08-15.
 */
@Controller
@RequestMapping("/leave")
public class HrRecLeaveController {
    @Resource
    private EmpMapper empMapper;
    @Resource
    private HrRecLeaveMapper hrRecLeaveMapper;

    @RequestMapping("/addUI.do")
    public String addUI(ModelMap modelMap){
        //准备员工数据
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        String endDate = sdf.format(c.getTime());
        c.add(Calendar.MONTH,-2);
        String stDate = sdf.format(c.getTime());
        List<EmpRec> empRecs = empMapper.getEmpRec(stDate,endDate);
        modelMap.addAttribute("empRecs",empRecs);
        return "hrRecLeave/add";
    }

    @RequestMapping("/viewOfMonth.do")
    public String viewOfMonth(){
        return "hrRecLeave/viewOfMonth";
    }

    @RequestMapping("/listOfPo.do")
    public String listOfPo(RecordPagePo recordPagePo,ModelMap modelMap){
        if(recordPagePo.getMonth().trim().length() <= 0){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            recordPagePo.setMonth(sdf.format(new Date()));
        }
        List<HrRecLeaveCustom> customs = hrRecLeaveMapper.getByPo(recordPagePo);
        modelMap.addAttribute("customs",customs);
        return "hrRecLeave/list";
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public Map<String,Object> add(HrRecLeave hrRecLeave,HttpSession httpSession){
        Map<String,Object> map = new HashMap<String, Object>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        hrRecLeave.setOperDate(sdf.format(new Date()));
        hrRecLeave.setOperId((String) httpSession.getAttribute("accountId"));
        // 请假单不存在的话添加
        if(hrRecLeaveMapper.hasLeave(hrRecLeave.getEmpId(),hrRecLeave.getStDate()) == 0) {
            hrRecLeaveMapper.add(hrRecLeave);
            map.put("result","Y");
        }
        return map;
    }

    @RequestMapping("/update.do")
    @ResponseBody
    public boolean update(HrRecLeave hrRecLeave,HttpSession httpSession){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        hrRecLeave.setOperDate(sdf.format(new Date()));
        hrRecLeave.setOperId((String) httpSession.getAttribute("accountId"));
        hrRecLeaveMapper.update(hrRecLeave);
        return true;
    }

    @RequestMapping("/updateUI.do")
    public String updateUI(int id,ModelMap modelMap){
        //准备员工数据
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        String endDate = sdf.format(c.getTime());
        c.add(Calendar.MONTH,-2);
        String stDate = sdf.format(c.getTime());
        List<EmpRec> empRecs = empMapper.getEmpRec(stDate,endDate);
        modelMap.addAttribute("empRecs",empRecs);
        //根据id查询请假单
        HrRecLeaveCustom custom = hrRecLeaveMapper.getById(id);
        modelMap.addAttribute("custom",custom);
        return "hrRecLeave/updateUI";
    }

    @RequestMapping("/delete.do")
    public String delete(int id){
        hrRecLeaveMapper.delete(id);
        return "hrRecLeave/viewOfMonth";
    }


    //批量调班
    @RequestMapping("/addChangeShift.do")
    @ResponseBody
    public boolean addChangeShift(@RequestParam("empIds[]") List<String> empIds, String stDate, String endDate,HttpSession httpSession) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        if(stDate == null || stDate.trim().length() <= 0){
            stDate = s.format(new Date());
        }
        if(endDate == null || endDate.trim().length()<=0){
            endDate = s.format(new Date());
        }
        HrChangeShiftPo p = new HrChangeShiftPo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        p.setOperDate(sdf.format(new Date()));
        p.setOperId((String) httpSession.getAttribute("accountId"));
        p.setStDate(stDate);
        p.setEndDate(endDate);
        for(int i=0;i<empIds.size();i++){
            p.setEmpId(empIds.get(i));
            hrRecLeaveMapper.saveChangeShifts(p);
        }
        return true;
    }
}
