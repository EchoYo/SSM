package com.echo.mySqlMapper;

import com.echo.model.Nature;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-07-06.
 */
@Repository
public interface NatureMapper {
    List<Nature> findAll();
}
