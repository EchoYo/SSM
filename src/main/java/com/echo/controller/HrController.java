package com.echo.controller;

import com.echo.hrSqlMapper.EquCardMapper;
import com.echo.hrSqlMapper.HrEmployeeMapper;
import com.echo.model.Emp;
import com.echo.model.EmpCustom;
import com.echo.model.HrShift;
import com.echo.mySqlMapper.EmpMapper;
import com.echo.mySqlMapper.HrRecShiftMapper;
import com.echo.util.ExpHrEmp;
import com.echo.util.ImportEmpExcel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-06-28.
 */
@Controller
@RequestMapping("/hr")
public class HrController {
    @Resource
    private EmpMapper empMapper;

    @Resource
    private HrEmployeeMapper hrEmployeeMapper;

    @Resource
    private EquCardMapper equCardMapper;

    @Resource
    private HrRecShiftMapper hrRecShiftMapper;

    @RequestMapping("/list.do")
    public String list(ModelMap modelMap){
        List<EmpCustom> lists = empMapper.findListCustom();
        modelMap.addAttribute("lists",lists);
        return "hrPage/hrlist";
    }


    @RequestMapping("/addUI.do")
    public String addUI(ModelMap modelMap){
        //准备班次信息
        List<HrShift> shifts = hrRecShiftMapper.getAllShift();
        modelMap.addAttribute("shifts",shifts);
        return "hrPage/saveUI";
    }

    @RequestMapping("/add.do")
    public @ResponseBody Map<String,Object> add(Emp emp){
        //准备EmpId
        String s = empMapper.getMaxEmpId();
        if(s == null){
            s = "0";
        }
        Long l = Long.parseLong(s)+1;
        s = l.toString();
        while(s.length()<8){
            s = "0"+s;
        }
        emp.setEmpId(s);
        empMapper.add(emp);
        //写入sql数据库
        hrEmployeeMapper.add(emp);
        //将指纹号写入sql
        equCardMapper.add(emp.getCardId(),emp.getEmpId());
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("x","add");
        return map;
    }

    @RequestMapping("/updateUI.do")
    public String updateUI(String empId,ModelMap modelMap){
        EmpCustom empCustom = empMapper.getEmpCustom(empId);
        modelMap.addAttribute("empCustom",empCustom);
        //准备班次信息
        List<HrShift> shifts = hrRecShiftMapper.getAllShift();
        modelMap.addAttribute("shifts",shifts);
        return "hrPage/saveUI";
    }

    @RequestMapping("/empDetail.do")
    public String empDetail(String empId,ModelMap modelMap){
        EmpCustom empCustom = empMapper.getEmpCustom(empId);
        modelMap.addAttribute("empCustom",empCustom);
        return "hrPage/empDetail";
    }

    @RequestMapping("/update.do")
    public @ResponseBody Map<String,Object> update(Emp emp){
        int y = 0;
        empMapper.update(emp);
        y = hrEmployeeMapper.countOfId(emp.getEmpId());
        if(y != 0){
            hrEmployeeMapper.update(emp);
        }else {
            hrEmployeeMapper.add(emp);
        }

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("x","update");
        return map;
    }

    @RequestMapping("/leave.do")
    public String leave(@ModelAttribute("emp")Emp emp){
        String leaveDate = emp.getLeaveDate();
        Emp emp1 = empMapper.getEmp(emp);
        emp1.setLeaveDate(leaveDate);
        emp1.setLeaveYN("Y");
        empMapper.update(emp1);
        return "redirect:/hr/list.do";
    }

    @RequestMapping("/allLeave.do")
    public String allLeave(ModelMap modelMap){
        List<EmpCustom> lists = empMapper.findLeaveCustom();
        modelMap.addAttribute("lists",lists);
        return "/hrPage/leavelist";
    }
    //撤销离职
    @RequestMapping("/revoke.do")
    public String revoke(@ModelAttribute("emp")Emp emp){
        Emp emp1 = empMapper.getEmp(emp);
        emp1.setLeaveDate("");
        emp1.setLeaveYN("N");
        empMapper.update(emp1);
        return "redirect:/hr/allLeave.do";
    }
    //导入花名册
    @RequestMapping("/importData.do")
    public String importData(){
        //得到表格中所有的数据
        List<Emp> listExcel = ImportEmpExcel.getAllByExcel("D://emp.xlsx");
        empMapper.addTrain(listExcel);
        return "redirect:/hr/list.do";
    }

    //导出在职人员名单
    @RequestMapping("/exportData.do")
    public String exportData(){
        String expFilePath =  "D://downLoadExcels//在职人员名单.xlsx";
        List<Emp> lists = empMapper.EmpForDownLoad("N");
        ExpHrEmp.expExcel(expFilePath, lists);
        return "hrPage/downLoadzz";
    }

    //导出离职人员名单
    @RequestMapping("/exportLaveData.do")
    public String exportLaveData(){
        String expFilePath =  "D://downLoadExcels//离职人员名单.xlsx";
        List<Emp> lists = empMapper.EmpForDownLoad("Y");
        ExpHrEmp.expExcel(expFilePath, lists);
        return "hrPage/downLoadlz";
    }
}
