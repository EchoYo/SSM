package com.echo.mySqlMapper;

import com.echo.model.HrRecOver;
import com.echo.model.HrRecOverCustom;
import com.echo.model.RecordPagePo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description:加班单</p>
 * Created by Echoj on 2016-08-17.
 */
@Repository
public interface HrRecOverMapper {
    List<HrRecOverCustom> getByPo(RecordPagePo recordPagePo);

    void add(HrRecOver hrRecOver);

    void update(HrRecOver hrRecOve);

    void delete(int id);

    HrRecOverCustom getById(int id);

    //找出加班单加班时间
    String getOverHours(String empId,String recDate);
}
