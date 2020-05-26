package com.lin.landao.controller;

import com.lin.landao.entities.Inn;
import com.lin.landao.service.InnService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
public class InnController {
    @Resource
    private InnService innService;

    @RequestMapping(value = "/innlist.action")
    public ModelAndView innList(HttpServletRequest requset, HttpServletResponse response) throws IOException {
        // 从Mysql中查询
        List<Inn> inns = innService.queryInnAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("inns", inns);
        mav.setViewName("innlist");
        return mav;
    }


}
