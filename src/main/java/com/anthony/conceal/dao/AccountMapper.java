package com.anthony.conceal.dao;


import com.anthony.conceal.dto.AccountDTO;

import java.util.List;

/**
 * Created by Anthony on 2016/12/22.
 */
public interface AccountMapper {
    List<AccountDTO> getAccountsByUserName(String userName);
}
