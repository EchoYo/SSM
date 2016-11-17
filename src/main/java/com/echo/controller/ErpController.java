package com.echo.controller;


import com.echo.erpMapper.InventoryMapper;
import com.echo.model.Inventory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-06-24.
 */
@Controller
@RequestMapping("/erp")
public class ErpController {
    @Resource
    private InventoryMapper inventoryMapper;
    @RequestMapping("/getByCode.do")
    @ResponseBody
    public Map<String,Object> getByCode(String cInvAddCode){
        List<Inventory> list = inventoryMapper.getByCode(cInvAddCode);
        Map<String,Object> map = new HashMap<String, Object>();
        for(int i = 0;i<list.size();i++){
            map.put("t"+i,list.get(i));
        }
        return map;
    }

}
