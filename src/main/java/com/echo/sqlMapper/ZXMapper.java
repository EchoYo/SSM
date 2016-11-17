package com.echo.sqlMapper;

import com.echo.model.ZX;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-06-20.
 */
@Repository
public interface ZXMapper {
    void save(ZX zx);
    void update(ZX zx);
    ZX getById(Integer serial_no);
    List<ZX> findAll();
}
