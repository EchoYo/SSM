package com.echo.mySqlMapper;

import com.echo.model.HrDept;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-07-01.
 */
@Repository
public interface HrDeptMapper {
    /**
     * 根据id查询部门信息
     * @param id
     * @return
     */
    HrDept findById(Long id);

    /**
     * 查询所有部门信息
     * @return
     */
    List<HrDept> findAll();

    /**
     * 修改部门信息
     * @param hrDept
     */
    void update(HrDept hrDept);

    /**
     * 添加部门信息
     * @param hrDept
     */
    void add(HrDept hrDept);
}
