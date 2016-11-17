package com.echo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description:用户</p>
 * Created by Echoj on 2016-06-12.
 */
public class Account {
    private String accountId;
    private String userName;
    private String passWord;
    private String roleId;
    private List<Role> roles = new ArrayList<Role>();//用户对应所有的角色

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

