package com.anthony.conceal.service;

import com.anthony.conceal.dao.UserMapper;
import com.anthony.conceal.dto.UserDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by CHENDONG239 on 2016-12-29.
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public UserDTO userLogin(String userName) {
        return userMapper.getUserDTObyUserName(userName);
    }

    public boolean userRegister(UserDTO userDTO) {
        if (null == userMapper.getUserDTObyUserName(userDTO.getUserName()) && userMapper.addUser(userDTO) == 1) {
            return true;
        }
        return false;
    }
}
