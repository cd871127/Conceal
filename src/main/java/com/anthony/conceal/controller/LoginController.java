package com.anthony.conceal.controller;

import com.anthony.conceal.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Anthony on 2016/12/27.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "login.do",method = POST)
    public String userLogin(HttpServletRequest request)
    {
        System.out.println("login");
        String s=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(s);
        System.out.println(password);
        return "/test";
    }
}
