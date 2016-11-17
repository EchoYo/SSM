package com.echo.mySqlMapper;

import com.echo.model.Account;
import com.echo.model.Privilege;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-06-16.
 */
@Repository
public interface PrivilegeMapper {
    //根据parentId查询所有子权限
    List<Privilege> getChildren(Privilege privilege);
    //查询用户所有顶级权限
    List<Privilege> getTopPrivilege(Account account);
    //查询用户的所有权限
    List<Privilege> getAllPrivilegeOfAccount(Account account);
    //根据Id查找权限
    Privilege getById(String privilegeId);
    //查找所有权限
    List<Privilege> getAllPrivilege();
    //查找所有顶点
    List<Privilege> getAllTopPrivlege();
}
