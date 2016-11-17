package com.echo.controller;

import com.echo.model.WX;
import com.echo.sqlMapper.WXMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Echoj on 2016/4/25.
 */
@Controller
@RequestMapping("/wx")
public class WXController {
    @Qualifier("WXMapper")
    @Resource
    private WXMapper wxMapper;

    @RequestMapping("/addUI.do")
    public String addUI(){
        return "labelPage/wxSaveUI";
    }

    @RequestMapping("/add.do")
    public String add(HttpServletRequest rs){
        String order_id = rs.getParameter("order_id").toUpperCase();
        String type_id = rs.getParameter("type_id").toUpperCase();
        String build_no = rs.getParameter("build_no").toUpperCase();
        Integer month = Integer.parseInt(rs.getParameter("month"));
        String item_no = rs.getParameter("item_no").toUpperCase();
        String qyt = rs.getParameter("qyt").toUpperCase();
        wxMapper.save(new WX(order_id,type_id,build_no,month,item_no,qyt));
        return "redirect:/wx/list.do";
    }


    @RequestMapping("/list.do")
    public String list(ModelMap modelMap){
        List<WX> list = wxMapper.findAll();
       modelMap.addAttribute("list", list);
        return "labelPage/wxlist";
    }

    @RequestMapping("/updateUI.do")
    public String updateUI(int id,ModelMap modelMap){
        WX wx = wxMapper.getById(id);
        modelMap.addAttribute("wx",wx);
        return "labelPage/wxSaveUI";
    }

    @RequestMapping("/update.do")
    public String update(HttpServletRequest rs){
        Integer id = Integer.parseInt(rs.getParameter("id"));
        String order_id = rs.getParameter("order_id");
        String type_id = rs.getParameter("type_id");
        String build_no = rs.getParameter("build_no");
        Integer month = Integer.parseInt(rs.getParameter("month"));
        String item_no = rs.getParameter("item_no");
        String qyt = rs.getParameter("qyt");
        WX wx = new WX(order_id,type_id,build_no,month,item_no,qyt);
        wx.setId(id);
        wxMapper.update(wx);
        return "redirect:/wx/list.do";
    }

}
