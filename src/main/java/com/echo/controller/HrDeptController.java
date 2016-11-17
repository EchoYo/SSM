package com.echo.controller;

import com.echo.model.HrDept;
import com.echo.mySqlMapper.HrDeptMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-07-01.
 */
@Controller
@RequestMapping("/dept")
public class HrDeptController {
    @Resource
    private HrDeptMapper hrDeptMapper;

    @RequestMapping("/list.do")
    public String list(ModelMap modelMap){
        List<HrDept> lists = hrDeptMapper.findAll();
        modelMap.addAttribute("lists",lists);
        return "hrDept/hrDeptList";
    }

    @RequestMapping("/addUI.do")
    public String addUI(){
        return "hrDept/hrDeptSaveUI";
    }

    @RequestMapping("/add.do")
    public String add(@ModelAttribute("hrDept") HrDept hrDept){
        hrDeptMapper.add(hrDept);
        return "redirect:/dept/list.do";
    }

    @RequestMapping("/updateUI.do")
    public String updateUI(@RequestParam Long id,ModelMap modelMap){
        HrDept hrDept = hrDeptMapper.findById(id);
        modelMap.addAttribute("dept",hrDept);
        return "hrDept/hrDeptSaveUI";
    }

    @RequestMapping("/update.do")
    public String update(@ModelAttribute("hrDept") HrDept hrDept){
        hrDeptMapper.update(hrDept);
        return "redirect:/dept/list.do";
    }

    @RequestMapping("/getDeptForHr.do")
    @ResponseBody
    public Map<String,Object> getDeptForHr(){
        List<HrDept> list = hrDeptMapper.findAll();
        Map<String,Object> map = new HashMap<String, Object>();
        for(int i = 0;i<list.size();i++){
            map.put("t"+i,list.get(i));
        }
        return map;
    }
}
