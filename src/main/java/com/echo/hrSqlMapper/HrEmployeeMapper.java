package com.echo.hrSqlMapper;

import com.echo.model.Emp;
import org.springframework.stereotype.Repository;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-09-08.
 */
@Repository
public interface HrEmployeeMapper {
    void add(Emp emp);

    void update(Emp emp);

    Integer countOfId(String id);
}
