package com.echo.hrSqlMapper;

import org.springframework.stereotype.Repository;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-09-08.
 */
@Repository
public interface EquCardMapper {
    void add(String cardId,String empId);
}
