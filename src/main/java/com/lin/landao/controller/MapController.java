package com.lin.landao.controller;

import com.lin.landao.entities.Scenery;
import com.lin.landao.service.SceneryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Controller
@Slf4j
public class MapController {
    @Resource
    private SceneryService sceneryService;

    @RequestMapping(value = "/map.action", method = RequestMethod.GET)
    public String map() {
        return "map";
    }

    @RequestMapping(value = "/map1.action", method = RequestMethod.GET)
    public String map1() {
        return "map1";
    }

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    @ResponseBody
    public Scenery demo(String x, String y) {
//        System.out.println(x);
//        System.out.println(y);
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("sceneryAbscissa",x);
//        map.put("sceneryOrdinate",y);
//        Scenery scenery = sceneryService.getSceneryByCoordinate(map);


        Scenery scenery = new Scenery();
        BigDecimal sceneryAbscissa = new BigDecimal(x);
        BigDecimal sceneryOrdinate = new BigDecimal(y);
        List<Scenery> sceneries = sceneryService.querySceneryAll();
        for (Scenery scenery1 : sceneries) {
            BigDecimal abscissaMin = scenery1.getAbscissaMin();
            BigDecimal ordinateMin =scenery1.getOrdinateMin();
            BigDecimal abscissaMax = scenery1.getAbscissaMax();
            BigDecimal ordinateMax = scenery1.getOrdinateMax();
            //判断是否在范围内
            if (sceneryAbscissa.compareTo(abscissaMax) < 0 && sceneryAbscissa.compareTo(abscissaMin) > 0 && sceneryOrdinate.compareTo(ordinateMax) < 0 && sceneryOrdinate.compareTo(ordinateMin) > 0) {
                System.out.println("____________________________"+scenery1.getSceneryName());
                BeanUtils.copyProperties(scenery1,scenery);
            }
        }


        return scenery;
    }
}
