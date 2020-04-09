package com.lin.landao.controller;


import com.lin.landao.entities.Admin;
import com.lin.landao.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Slf4j
@Controller
public class AdminController {

//    @Resource
    @Autowired
    private AdminService adminService;

//
//
//
//    @ResponseBody
//    @GetMapping(value = "admin/get/{id}")
//    public Admin getAdminById(@PathVariable("id") Integer id) {
//
//        Admin adminById = adminService.getAdminById(id);
//        System.out.println(adminById.getAdminName());
//        return adminById;
//    }


    @RequestMapping(value = "/Admlogin.action", method = RequestMethod.GET)
    public String Autlogin() {
        return "Admlogin";
    }

    @RequestMapping(value = "/Admlogin.action", method = RequestMethod.POST)
    public String Autlogin(String adminname, String password, HttpServletRequest request, HttpServletResponse response) {

        Admin admin = adminService.Adminlogin(adminname, password);
        if (admin == null) {
            return"error";
        }
        HttpSession session=request.getSession();
        session.setAttribute("innId", admin.getInnId());
        return "redirect:/seller/order/list";
    }


}
