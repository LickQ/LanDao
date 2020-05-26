package com.lin.landao.controller;

import com.lin.landao.entities.User;
import com.lin.landao.service.StrategyService;
import com.lin.landao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StrategyService strategyService;

    // 去登陆的页面
    @RequestMapping(value = "/index.action", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    // 去登陆的页面
    @RequestMapping(value = "/userLogin.action", method = RequestMethod.GET)
    public String Autlogin() {
        return "userLogin";
    }

    @RequestMapping(value = "/userLogin.action", method = RequestMethod.POST)
    public String Autlogin(String username, String userpassword, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = userService.getUserByUserName(username);
        if (user.getUserPassword()==userpassword){
            return "error";
        }
        session.setAttribute("user",user);
        session.setAttribute("username",username);
        session.setAttribute("userId",user.getUserId());
        return "redirect:/strategylist.action";
    }

    //注销
    @RequestMapping(value = "/logout.action")
    public String alogout(HttpServletRequest request,HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:/strategylist.action";

    }

    // 前往注册界面
    @RequestMapping(value = "/register.action", method = RequestMethod.GET)
    public String Autregister() {
        return "register";
    }
    @RequestMapping(value = "/register.action", method = RequestMethod.POST)
    public String Register(User user) {
        // 添加用户
        userService.create(user);
        return "redirect:/userLogin.action";
    }


}
