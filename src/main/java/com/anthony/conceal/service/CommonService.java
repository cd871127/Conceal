package com.anthony.conceal.service;

import com.anthony.conceal.dao.CommonMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by CHENDONG239 on 2017-01-03.
 */
@Service
public class CommonService {
    @Resource
    private CommonMapper commonMapper;

    Map<String,Map<String,String>> queryDataDict(Map<String,String> paraMap){
        return commonMapper.queryDataDict(paraMap);
    }
}
