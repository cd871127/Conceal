package com.anthony.conceal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by CHENDONG239 on 2016-12-27.
 */
@Controller
public class TestController {
    @RequestMapping(value = "/test",method = GET)
    public String test()
    {
        return "/test";
    }
}
