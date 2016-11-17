package com.echo.hrSqlMapper;

import com.echo.model.HrRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description:sql原始刷卡数据表</p>
 * Created by Echoj on 2016-07-11.
 */
@Repository
public interface AtdRecordMapper {
    //查询个数
    Integer findData (String recDate);
    //按天查询
    List<HrRecord> getByDate(String date);
    //获取id最大值
    Integer findMaxId();
    //根据Id范围查询打卡记录
    List<HrRecord> getNewDatas(Integer stId,Integer endId);
    //添加打卡记录
    void add(HrRecord hrRecord);
    //删除打卡记录
    void delete(Integer id);
    //查询单个记录
    HrRecord getById(Integer id);
}
