package com.anthony.conceal.service;

import com.anthony.conceal.dao.AccountMapper;
import com.anthony.conceal.dto.AccountDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Anthony on 2017/1/1.
 */
@Service
public class AccountService {
    @Resource
    private AccountMapper accountMapper;

    public List<AccountDTO> queryAccountByPaging(Map<String, Object> paraMap) {
        return accountMapper.queryAccountByPaging(paraMap);
    }

    public int delAccountByIDs(List<String> ids)
    {
        return accountMapper.delAccountByIDs(ids);
    }
    public int queryAccountCountByUserName(String userName)
    {
        return accountMapper.queryAccountCountByUserName(userName);
    }

}
