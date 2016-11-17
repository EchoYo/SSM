package com.echo.controller;

import com.echo.model.Account;
import com.echo.model.Privilege;
import com.echo.mySqlMapper.AccountMapper;
import com.echo.mySqlMapper.PrivilegeMapper;
import com.echo.util.Tree;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-06-12.
 */
@Controller
public class LoginController {
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private PrivilegeMapper privilegeMapper;

    @RequestMapping("/login.do")
    public String goToLoginPage(){
        return "login/login";
    }

    @RequestMapping("/toLogin.do")
    public String toLogin(@RequestParam("username") String accountId,
                        @RequestParam("password") String passWord,
                         HttpSession httpSession,ModelMap modelMap) {
        Account account = accountMapper.getByAccountId(accountId);
        if ((account != null) && (passWord.equals(account.getPassWord()))) {
            httpSession.setAttribute("username",account.getUserName());
            httpSession.setAttribute("accountId",account.getAccountId());
            httpSession.setAttribute("roleId",account.getRoleId());
            return "redirect:/index.do";
        }else{
            modelMap.addAttribute("message","账户或密码出错！");
            modelMap.addAttribute("accountId",accountId);
            return "login/login";
        }
    }

    @RequestMapping("/index.do")
    public String goToIndex(ModelMap modelMap,HttpSession httpSession){
        String accountId = (String) httpSession.getAttribute("accountId");
        //判断管理员
        if("admin".equals(accountId)){
            //获取所有顶点权限
            List<Privilege> adminAllTopPrivileges = privilegeMapper.getAllTopPrivlege();
            modelMap.addAttribute("list",adminAllTopPrivileges);
        }else {
            //根据登录名查询出用户信息
            Account account = accountMapper.getByAccountId(accountId);
            //准备菜单数据
            List<Privilege> indexMenu = privilegeMapper.getTopPrivilege(account);
            modelMap.addAttribute("list", indexMenu);
        }
        return "login/index";
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/login.do";
    }

    @RequestMapping("/labelUI.do")
    public String labelUI(HttpSession httpSession,ModelMap modelMap){
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
        Privilege topPrivilegeForPage = privilegeMapper.getById("P109");

        //调用Tree方法
        Privilege privilege = Tree.makeTree(topPrivilegeForPage, allPrivileges);
        modelMap.addAttribute("privilege",privilege);
        return "labelPage/labelUI";
    }

    @RequestMapping("/hrUI.do")
    public String hrUI(HttpSession httpSession,ModelMap modelMap){
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
        Privilege topPrivilegeForPage = privilegeMapper.getById("P110");

        //调用Tree方法
        Privilege privilege = Tree.makeTree(topPrivilegeForPage, allPrivileges);
        modelMap.addAttribute("privilege",privilege);
        return "hrPage/hrUI";
    }
}
