package com.anthony.conceal.controller.account;

import com.anthony.conceal.common.ResObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Anthony on 2017/1/1.
 */
@Controller
@RequestMapping("account")
public class AccountController {

    @RequestMapping(value = "queryAccount.do", method = RequestMethod.POST)
    @ResponseBody
    public ResObject queryAccount(HttpServletRequest request) {
        int pageSize = Integer.valueOf(request.getParameter("pageSize"));

        return null;
    }
}
