package com.anthony.conceal.controller;

import com.anthony.conceal.dto.UserDTO;
import com.anthony.conceal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by CHENDONG239 on 2016-12-29.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register.do",method = RequestMethod.GET)
    public String openRegisterPage()
    {
        return "register";
    }

    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    public String register(UserDTO userDTO)
    {
        System.out.println("pp");
        System.out.println(userDTO);
        return null;
    }
}
