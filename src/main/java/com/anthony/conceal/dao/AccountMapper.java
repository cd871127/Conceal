package com.anthony.conceal.dao;


import com.anthony.conceal.dto.AccountDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anthony on 2016/12/22.
 */
public interface AccountMapper {
    List<AccountDTO> queryAccountByPaging(Map<String,String> paraMap);
}
