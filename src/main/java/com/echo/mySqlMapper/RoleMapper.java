package com.echo.mySqlMapper;

import com.echo.model.Privilege;
import com.echo.model.Role;
import org.springframework.stereotype.Repository;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-06-16.
 */
@Repository
public interface RoleMapper {
    //根据role查询出对应的权限
    Privilege getByPrivilegeId(Role role);
}
