package com.anthony.conceal.controller;

import com.anthony.conceal.common.ResObject;
import com.anthony.conceal.dao.UserMapper;
import com.anthony.conceal.dto.UserDTO;
import com.anthony.conceal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login.do", method = POST)
    @ResponseBody
    public ResObject userLogin(UserDTO userDTO) {
        String userName = userDTO.getUserName();
        String passWord = userDTO.getPassWord();
        userDTO = userService.userLogin(userName);
        String message;
        String code;

        if (null != userDTO && userDTO.getPassWord().equals(passWord)) {
            message = "登录成功";
            code = "00";
        } else {
            message = "登录失败";
            code = "01";
        }
        Map<String, String> res = new HashMap<>();
        res.put("res", message);
        ResObject resObject = new ResObject.ResObjectBuilder().code(code).content(res).message(message).build();
        return resObject;
    }
}
