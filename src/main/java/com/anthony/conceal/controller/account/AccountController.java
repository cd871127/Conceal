package com.anthony.conceal.controller.account;

import com.anthony.conceal.common.ResObject;
import com.anthony.conceal.dto.AccountDTO;
import com.anthony.conceal.dto.UserDTO;
import com.anthony.conceal.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anthony on 2017/1/1.
 */
@Controller
@RequestMapping("account")
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping(value = "queryAccount.do", method = RequestMethod.POST)
    @ResponseBody
    public ResObject queryAccount(HttpServletRequest request) {
        Integer pageSize = Integer.valueOf(request.getParameter("pageSize"));
        Integer startIndex = Integer.valueOf(request.getParameter("startIndex"));
        Map<String, Object> paraMap = new HashMap<>();
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
        paraMap.put("pageSize", pageSize);
        paraMap.put("startIndex", startIndex);
        paraMap.put("userName", userDTO.getUserName());
        List<AccountDTO> resList = accountService.queryAccountByPaging(paraMap);

        return new ResObject.ResObjectBuilder().code(ResObject.SUCCESS).message("").content(resList).build();
    }

    @RequestMapping(value = "queryAccountCount.do", method = RequestMethod.POST)
    @ResponseBody
    public ResObject queryAccountCount(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
        int dataCount = accountService.queryAccountCountByUserName(userDTO.getUserName());
        return new ResObject.ResObjectBuilder().code(ResObject.SUCCESS).message("").content(dataCount).build();
    }

    @RequestMapping(value = "delAccount.do", method = RequestMethod.POST)
    @ResponseBody
    public ResObject delAccount(HttpServletRequest request) {
        List<String> ids = Arrays.asList(request.getParameter("ids").split(","));
        int count = accountService.delAccountByIDs(ids);
        return new ResObject.ResObjectBuilder().code(ResObject.SUCCESS).message("").content(count).build();
    }


}
