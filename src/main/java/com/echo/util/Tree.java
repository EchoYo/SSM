package com.echo.util;

import com.echo.model.Privilege;

import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-06-18.
 */
public class Tree {
    public static Privilege makeTree(Privilege privilege,List<Privilege> privileges){
        //遍历所有该用户拥有的权限
        for (Privilege a : privileges){
            //判断是否有parentId等于顶点的Id的时候
            if(privilege.getPrivilegeId().equals(a.getParentId())){
                //如果有  子节点继续调用tree方法 知道没有子节点 再把得到的Privilege对象添加到父节点的privileges集合中
                privilege.getPrivileges().add(makeTree(a,privileges));
            }
        }
        return  privilege;
    }
}
