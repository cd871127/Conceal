package com.anthony.conceal.controller;

import com.anthony.conceal.dao.UserMapper;
import com.anthony.conceal.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Anthony on 2016/12/27.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "login.do", method = POST)
    @ResponseBody
    public Map<String, String> userLogin(@RequestBody UserDTO userDTO) {
        String pwd = userMapper.userLogin(userDTO.getUserName());
        String message;
        if (null == pwd) {
            //没有用户
            message = "不存在用户" + userDTO.getUserName();
        } else {
            if (pwd.equals(userDTO.getPassWord())) {
                message = "ok";
            } else {
                message = "密码错误";
            }
        }
        Map<String, String> res = new HashMap<>();
        res.put("res", message);

        return res;
    }
}
