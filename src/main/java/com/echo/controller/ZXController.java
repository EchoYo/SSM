package com.echo.controller;

import com.echo.model.ZX;
import com.echo.sqlMapper.ZXMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-06-20.
 */
@Controller
@RequestMapping("/zx")
public class ZXController {
    @Qualifier("ZXMapper")
    @Resource
    private ZXMapper zxMapper;

    @RequestMapping("/addUI.do")
    public String addUI(){
        return "labelPage/zxSaveUI";
    }

    @RequestMapping("/list.do")
    public String list(ModelMap modelMap){
        List<ZX> list = zxMapper.findAll();
        modelMap.addAttribute("list", list);
        return "labelPage/zxlist";
    }

    @RequestMapping("/add.do")
    public String add(HttpServletRequest request){
        String st_date = request.getParameter("st_date");
        String type_id ="J" + request.getParameter("type_id").toUpperCase();
        Integer month = Integer.parseInt(request.getParameter("month"));
        String qty = request.getParameter("qty").toUpperCase();
        String mat_code = request.getParameter("mat_code").toUpperCase();
        String batch = request.getParameter("batch").toUpperCase();
        zxMapper.save(new ZX(type_id,month,qty,mat_code,batch,st_date));
        return "redirect:/zx/list.do";
    }

    @RequestMapping("/updateUI.do")
    public String updateUI(int serial_no,ModelMap modelMap){
        ZX zx = zxMapper.getById(serial_no);
        modelMap.addAttribute("zx",zx);
        return "labelPage/zxSaveUI";
    }

    @RequestMapping("/update.do")
    public String update(HttpServletRequest request){
        String st_date = request.getParameter("st_date");
        Integer serial_no = Integer.parseInt(request.getParameter("serial_no"));
        String type_id = request.getParameter("type_id").toUpperCase();
        Integer month = Integer.parseInt(request.getParameter("month"));
        String qty = request.getParameter("qty").toUpperCase();
        String mat_code = request.getParameter("mat_code").toUpperCase();
        String batch = request.getParameter("batch").toUpperCase();
        ZX zx = new ZX(type_id,month,qty,mat_code,batch,st_date);
        zx.setSerial_no(serial_no);
        zxMapper.update(zx);
        return "redirect:/zx/list.do";
    }

}
