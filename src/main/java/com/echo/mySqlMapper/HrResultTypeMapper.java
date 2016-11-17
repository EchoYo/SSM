package com.echo.mySqlMapper;

import org.springframework.stereotype.Repository;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-09-01.
 */
@Repository
public interface HrResultTypeMapper {
    String getByType(String resultType);
}
