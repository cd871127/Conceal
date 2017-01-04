package com.anthony.conceal.controller.user;

import com.anthony.conceal.common.ResObject;
import com.anthony.conceal.dto.UserDTO;
import com.anthony.conceal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by CHENDONG239 on 2016-12-29.
 */
@Controller
@RequestMapping("user")
public class RegisterController {

    @Resource
    UserService userService;

    @RequestMapping(value = "register.do", method = RequestMethod.GET)
    public String openRegisterPage() {
        return "user/signup";
    }

    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    @ResponseBody
    public ResObject register(UserDTO userDTO, HttpServletRequest request) {
        String message = "注册成功";
        String code = ResObject.SUCCESS;
        String content = "";
        if (!userService.userRegister(userDTO)) {
            message = "注册失败";
            code = ResObject.REGISTER_FAIL;
        }
        HttpSession session = request.getSession();
        session.setAttribute("userDTO", userDTO);
        return new ResObject.ResObjectBuilder().code(code).message(message).content(content).build();
    }
}
