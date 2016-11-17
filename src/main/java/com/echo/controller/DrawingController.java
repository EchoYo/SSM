package com.echo.controller;

import com.echo.model.Account;
import com.echo.model.Drawing;
import com.echo.model.Privilege;
import com.echo.mySqlMapper.AccountMapper;
import com.echo.mySqlMapper.DrawingMapper;
import com.echo.mySqlMapper.PrivilegeMapper;
import com.echo.util.ImportExcel;
import com.echo.util.Tree;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * <p>Description:图纸</p>
 * Created by Echoj on 2016-06-08.
 */
@Controller
@RequestMapping("/drawing")
public class DrawingController {
    @Resource
    private DrawingMapper drawingMapper;
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private PrivilegeMapper privilegeMapper;

    @RequestMapping("/dwgUI.do")
    public String goToDwgUI(HttpSession httpSession,ModelMap modelMap) {
        List<Privilege> allPrivileges = new ArrayList<Privilege>();
        String accountId = (String) httpSession.getAttribute("accountId");
        //根据登陆用户查询对应的用户信息
        Account account = accountMapper.getByAccountId(accountId);
        //判断管理员
        if("admin".equals(accountId)){
            allPrivileges = privilegeMapper.getAllPrivilege();
        }else {
            //先查询出登陆用户的所有权限
            allPrivileges = privilegeMapper.getAllPrivilegeOfAccount(account);
        }
        //获取用户该页面的顶级权限对象
        Privilege topPrivilegeForPage = privilegeMapper.getById("P100");

       //调用Tree方法
        Privilege privilege = Tree.makeTree(topPrivilegeForPage,allPrivileges);
        modelMap.addAttribute("privilege",privilege);
        return "dwgPage/dwgUI";
    }

    @RequestMapping("/zylist.do")
    public String zylist(ModelMap modelMap) {
        List<Drawing> drawings = drawingMapper.findAll();
        modelMap.addAttribute("drawings", drawings);
        return "dwgPage/zylist";
    }

    @RequestMapping("/mjlist.do")
    public String mjlist(ModelMap modelMap) {
        List<Drawing> drawings = drawingMapper.findAll();
        modelMap.addAttribute("drawings", drawings);
        return "dwgPage/mjlist";
    }

    @RequestMapping("/sclist.do")
    public String sclist(ModelMap modelMap) {
        List<Drawing> drawings = drawingMapper.findAll();
        modelMap.addAttribute("drawings", drawings);
        return "dwgPage/sclist";
    }

    @RequestMapping("/addUI.do")
    public String addUI(ModelMap modelMap) {
        Long id = drawingMapper.getMaxId();
        if(id == null){
            id = (long) 1;
        }else{
            id = id + 1;
        }
        Drawing drawing = new Drawing();
        drawing.setId(id);
        modelMap.addAttribute("drawing", drawing);
        return "dwgPage/saveUI";
    }

    @RequestMapping("/add.do")
    //MultipartFile pic接收图纸信息
    public String add(Drawing drawing) {
//        ////上传图片 ,MultipartFile filename
//        if(!filename.isEmpty()){
//            //存储图片的物理路径
//            String path = "E:\\BaiduYunDownload\\";
//            //原始名称
//            String originalFilename = filename.getOriginalFilename();
//            //新的图片名称  UUID.randomUUID()随机数
//            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
//            //新图片
//            File newFile = new File(path + newFileName);
//            try {
//                //将内存的数据写入磁盘
//                filename.transferTo(newFile);
//                //将新图片名称写到drawing中
//                drawing.setRemark(newFileName);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        //获取当前系统时间
        String time = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        drawing.setDate(time);
        drawingMapper.add(drawing);


        return "redirect:/index.do";
    }

    @RequestMapping("/updateUI.do")
    public String updateUI(int id, ModelMap modelMap) {
        Drawing drawing = drawingMapper.getById(id);
        modelMap.addAttribute("drawing", drawing);
        return "dwgPage/saveUI";
    }

    @RequestMapping("/update.do")
    public String update(Drawing drawing) {
//        ////上传图片 ,MultipartFile filename
//        if(!filename.isEmpty()){
//            //存储图片的物理路径
//            String path = "E:\\BaiduYunDownload\\";
//            //原始名称
//            String originalFilename = filename.getOriginalFilename();
//            //新的图片名称  UUID.randomUUID()随机数
//            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
//            //新图片
//            File newFile = new File(path + newFileName);
//            try {
//                //将内存的数据写入磁盘
//                filename.transferTo(newFile);
//                //将新图片名称写到drawing中
//                drawing.setRemark(newFileName);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        drawingMapper.update(drawing);
        return "redirect:/index.do";
    }

    @RequestMapping("/searchUI.do")
    public String searchUI() {
        return "dwgPage/searchUI";
    }

    @RequestMapping("/importUI.do")
    public String importUI() {
        return "dwgPage/importUI";
    }

    @RequestMapping("/importData.do")
    public String importData() {
        //得到表格中所有的数据
        List<Drawing> listExcel = ImportExcel.getAllByExcel("D://book.xlsx");
        drawingMapper.addTrain(listExcel);
        return "redirect:/index.do";
    }
}
