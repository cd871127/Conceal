package com.anthony.conceal.controller.common;

import com.anthony.conceal.service.CommonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENDONG239 on 2017-01-03.
 */
@Controller
@RequestMapping("common")
public class CommonController {

    @Resource
    private CommonService commonService;

    @RequestMapping(value = "queryDataDict.do", method = RequestMethod.POST)
    @ResponseBody
    public String queryDataDict() {
        Map<String, String> paraMap = new HashMap<>();

        return null;
    }
}
