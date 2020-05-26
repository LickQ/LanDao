package com.lin.landao.dao;

import com.lin.landao.entities.Scenery;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SceneryMapperTest {

    @Resource
    private SceneryMapper sceneryMapper;
    @Test
    public void getSceneryByCoordinate() {
//        HashMap map= new HashMap();
//        map.put("sceneryAbscissa",119.786379);
//        map.put("sceneryOrdinate",25.624946);
//        Scenery scenery = sceneryMapper.getSceneryByCoordinate(map);
//        Assert.assertNotNull(scenery);

        BigDecimal sceneryOrdinate= BigDecimal.valueOf(25.558835);
        BigDecimal sceneryAbscissa= BigDecimal.valueOf(119.885903);

        BigDecimal abscissaMin = BigDecimal.valueOf(119.88);
        BigDecimal abscissaMax = BigDecimal.valueOf(119.89);
        BigDecimal ordinateMin = BigDecimal.valueOf(25.55);
        BigDecimal ordinateMax = BigDecimal.valueOf(25.56);
        //判断是否在范围内
        if (sceneryAbscissa.compareTo(abscissaMax) < 0 && sceneryAbscissa.compareTo(abscissaMin) > 0 && sceneryOrdinate.compareTo(ordinateMax) < 0 && sceneryOrdinate.compareTo(ordinateMin) > 0) {
            System.out.println("____________________________");
        }
        int a=sceneryAbscissa.compareTo(abscissaMax);
        int b=sceneryAbscissa.compareTo(abscissaMin);
        int c=sceneryOrdinate.compareTo(ordinateMax);
        int d=sceneryOrdinate.compareTo(ordinateMin);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}