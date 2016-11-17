package com.echo.sqlMapper;

import com.echo.model.WX;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-06-19.
 */
@Repository
public interface WXMapper {
    void save(WX wx);
    void update(WX wx);
    List<WX> findAll();
    WX getById(Integer id);
}
