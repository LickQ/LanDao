package com.lin.landao.controller;

import com.lin.landao.entities.Comment;
import com.lin.landao.entities.Strategy;
import com.lin.landao.entities.User;
import com.lin.landao.service.CommentService;
import com.lin.landao.service.StrategyService;
import com.lin.landao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
public class StrategyController {
    @Resource
    private CommentService commentService;
    @Resource
    private UserService userService;
    @Autowired
    private StrategyService strategyService;

    @RequestMapping(value = "/strategylist.action")
    public ModelAndView strategyList() throws IOException {
        // 从Mysql中查询
        List<Strategy> strategies = strategyService.queryStrategyAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("strategies", strategies);
        mav.setViewName("strategylist");
        return mav;
    }

    //详细界面
    @RequestMapping(value = "/findit.action")
    public ModelAndView findit(Integer id) {
        Strategy text = strategyService.getStrategyById(id);
        ModelAndView mav = new ModelAndView();
        Integer userId = text.getUserId();
        User user = userService.getUserById(userId);
        List<Comment> comments = commentService.queryCommentAllBystrategyId(id);

        // 数据
        mav.addObject("comments", comments);
        mav.addObject("user", user);
        mav.addObject("text", text);
        mav.setViewName("findit");
        return mav;
    }
    // 前往投稿
    @RequestMapping(value = "/addStrategry.action", method = RequestMethod.GET)
    public String addStrategry() {
        return "addStrategry";
    }

    @RequestMapping(value = "addStrategry.action", method = RequestMethod.POST)
    public String Autlogin(String title, String summary,String detail, HttpServletRequest request, HttpServletResponse response) {
        Strategy strategy = new Strategy();
        strategy.setStrategyCheckmark("0");
        strategy.setStrategyCreatetime(new Date());
        strategy.setStrategyDetail(detail);
        strategy.setSceneryId(1);
        strategy.setStrategyTitle(title);
        strategy.setStrategySummary(summary);
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("userId");
        strategy.setUserId((Integer) userId);
        strategy.setStrategyStatus(0);
        strategyService.create(strategy);


        return "redirect:/strategylist.action";
    }







}
