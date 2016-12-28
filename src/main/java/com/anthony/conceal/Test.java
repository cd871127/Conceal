package com.anthony.conceal;

import com.anthony.conceal.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by CHENDONG239 on 2016-12-28.
 */
@Component
public class Test {
    @Autowired
    private UserMapper userMapper;

    public void print() {
        System.out.println(userMapper.userLogin("cd871127"));
    }
}
