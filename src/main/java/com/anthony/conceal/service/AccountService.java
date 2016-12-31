package com.anthony.conceal.service;

import com.anthony.conceal.dao.AccountMapper;
import com.anthony.conceal.dto.AccountDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by Anthony on 2017/1/1.
 */
@Service
public class AccountService {
    @Resource
    private AccountMapper accountMapper;

    List<AccountDTO> queryAccountByPaging(Map<String,String> paraMap)
    {
        return accountMapper.queryAccountByPaging(paraMap);
    }

}
