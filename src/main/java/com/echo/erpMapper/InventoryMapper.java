package com.echo.erpMapper;


import com.echo.model.Inventory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-06-24.
 */
@Repository
public interface InventoryMapper {
    //按存货代码查询
    List<Inventory> getByCode(String cInvAddCode);
}
