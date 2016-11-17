package com.echo.controller;

import com.echo.model.Nature;
import com.echo.mySqlMapper.NatureMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-07-06.
 */
@Controller
@RequestMapping("/nature")
public class NatureController {
    @Resource
    private NatureMapper natureMapper;

    @RequestMapping("/getNatureForHr.do")
    @ResponseBody
    public Map<String,Object> getNatureForHr(){
        List<Nature> list = natureMapper.findAll();
        Map<String,Object> map = new HashMap<String, Object>();
        for(int i = 0;i<list.size();i++){
            map.put("t"+i,list.get(i));
        }
        return map;
    }
}
