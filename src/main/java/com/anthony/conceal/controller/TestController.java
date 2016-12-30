package com.anthony.conceal.controller;

import com.anthony.conceal.dto.TestDTO;
import com.anthony.conceal.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by CHENDONG239 on 2016-12-27.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value = "/test.do", method = GET)
    public String test(@RequestBody TestDTO testDTO) {
        System.out.println(testDTO);
        return "user/test";
    }

    @RequestMapping(value = "/test.do", method = POST)
    public String test2(UserDTO userDTO) {
        System.out.println("print");
        System.out.println(userDTO);
        return "user/test";
    }

    @RequestMapping(value = "/{userName}",method=GET)
    public String test3(@PathVariable String userName)
    {
        System.out.println(userName);
        return "user/test";
    }
}


