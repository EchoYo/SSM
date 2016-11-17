package com.echo.mySqlMapper;

import com.echo.model.HrShiftSect;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-08-23.
 */
@Repository
public interface HrShiftSectMapper {

    List<HrShiftSect> getById(String shiftId);
}
