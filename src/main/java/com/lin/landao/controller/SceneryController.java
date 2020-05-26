package com.lin.landao.controller;

import com.lin.landao.entities.Scenery;
import com.lin.landao.service.SceneryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
public class SceneryController {
    @Resource
    private SceneryService sceneryService;
    @RequestMapping(value = "/scenerylist.action")
    public ModelAndView innList() throws IOException {
        // 从Mysql中查询
        List<Scenery> sceneries = sceneryService.querySceneryAllByHotValue();
        ModelAndView mav = new ModelAndView();
        mav.addObject("sceneries", sceneries);
        mav.setViewName("scenerylist");
        return mav;
    }

    @RequestMapping(value = "/sceneryDetal.action")
    public ModelAndView sceneryDetal(Integer sceneryId) throws IOException {
        // 从Mysql中查询
        Scenery scenery = sceneryService.getSceneryById(sceneryId);
        int a=scenery.getSceneryHotvalue()+1;
        Scenery scenery1=new Scenery();
        BeanUtils.copyProperties(scenery, scenery1);
        scenery1.setSceneryHotvalue(a);
        sceneryService.updateSceneryById(scenery1);
        ModelAndView mav = new ModelAndView();
        mav.addObject("scenery",scenery);
        mav.setViewName("sceneryDetal");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/category.action")
    public List<Scenery> Scenery(HttpServletRequest requset, HttpServletResponse response)throws IOException {
        List<Scenery> Scenerylist=sceneryService.querySceneryAll();
        return Scenerylist;
    }

}
