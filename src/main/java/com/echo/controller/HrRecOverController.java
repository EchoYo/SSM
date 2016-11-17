package com.echo.controller;

import com.echo.model.*;
import com.echo.mySqlMapper.EmpMapper;
import com.echo.mySqlMapper.HrRecOverMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>Description:加班单登记</p>
 * Created by Echoj on 2016-08-15.
 */
@Controller
@RequestMapping("/over")
public class HrRecOverController {
    @Resource
    private EmpMapper empMapper;
    @Resource
    private HrRecOverMapper hrRecOverMapper;

    @RequestMapping("/addUI.do")
    public String addUI(ModelMap modelMap){
        //准备员工数据
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String month = sdf.format(new Date());
        List<EmpRec> empRecs = empMapper.getForOver(month);
        modelMap.addAttribute("empRecs",empRecs);
        return "hrRecOver/saveList";
    }

    @RequestMapping("/viewOfMonth.do")
    public String viewOfMonth(){
        return "hrRecOver/viewOfMonth";
    }

    @RequestMapping("/listOfPo.do")
    public String listOfPo(RecordPagePo recordPagePo,ModelMap modelMap){
        if(recordPagePo.getMonth().trim().length() <= 0){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            recordPagePo.setMonth(sdf.format(new Date()));
        }
        List<HrRecOverCustom> customs = hrRecOverMapper.getByPo(recordPagePo);
        modelMap.addAttribute("customs",customs);
        return "hrRecOver/list";
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public boolean add(@RequestParam("empIds[]") List<String> empIds, String resultType, String recDate,
                       String stTime,String endTime,String hours,HttpSession httpSession) {
        HrRecOver h= new HrRecOver();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        h.setOperDate(sdf.format(new Date()));
        h.setOperId((String) httpSession.getAttribute("accountId"));
        h.setRecDate(recDate);
        h.setResultType(resultType);
        h.setStTime(stTime);
        h.setEndTime(endTime);
        h.setHours(hours);
        for(int i=0;i<empIds.size();i++){
            h.setEmpId(empIds.get(i));
            hrRecOverMapper.add(h);
        }

        return true;
    }

    @RequestMapping("/update.do")
    @ResponseBody
    public boolean update(HrRecOver hrRecOver,HttpSession httpSession){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        hrRecOver.setOperDate(sdf.format(new Date()));
        hrRecOver.setOperId((String) httpSession.getAttribute("accountId"));
        hrRecOverMapper.update(hrRecOver);
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
        HrRecOverCustom custom = hrRecOverMapper.getById(id);
        modelMap.addAttribute("custom",custom);
        return "hrRecOver/updateUI";
    }

    @RequestMapping("/delete.do")
    public String delete(int id){
        hrRecOverMapper.delete(id);
        return "hrRecOver/viewOfMonth";
    }
}
