package com.echo.mySqlMapper;


import com.echo.model.Account;
import com.echo.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-06-12.
 */
@Repository
public interface AccountMapper {
    //按登录名查询
    Account getByAccountId(String accountId);
    //用户对应所有的角色
    List<Role> getByRoleId(Account account);
    //根据用户登录名查询所有拥有顶级权限
}
