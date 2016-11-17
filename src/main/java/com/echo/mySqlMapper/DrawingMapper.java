package com.echo.mySqlMapper;


import com.echo.model.Drawing;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-06-08.
 */
@Repository
public interface DrawingMapper {
    //添加
    void add(Drawing drawing);
    //查询
    List<Drawing> findAll();
    //按id查询
    Drawing getById(int id);
    //修改
    void update(Drawing drawing);
    //批量添加
    void addTrain(List<Drawing> list);
    //最大编号
    Long getMaxId();
}
