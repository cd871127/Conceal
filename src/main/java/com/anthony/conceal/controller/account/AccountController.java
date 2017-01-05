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
import java.util.*;

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
    public List<AccountDTO> queryAccount(HttpServletRequest request) {
        Integer pageSize = Integer.valueOf(request.getParameter("pageSize"));
        Integer startIndex = Integer.valueOf(request.getParameter("startIndex"));
        Map<String, Object> paraMap = new HashMap<>();
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
        paraMap.put("pageSize", pageSize);
        paraMap.put("startIndex", startIndex);
        paraMap.put("userName", userDTO.getUserName());
        List<AccountDTO> resList = accountService.queryAccountByPaging(paraMap);
//        return new ResObject.ResObjectBuilder().code(ResObject.SUCCESS).message("").content(resList).build();
        return resList;
    }

    private void printRequest(HttpServletRequest request)
    {
        System.out.println("print request:");
        Map m=request.getParameterMap();
        Set<Map.Entry<String, String>> set = m.entrySet();
        for(Map.Entry entry : set)
        {
            System.out.println(entry.getKey() + ":" + Arrays.toString((String[])entry.getValue()));
        }
    }
}
