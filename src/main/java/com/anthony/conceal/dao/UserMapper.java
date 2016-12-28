package com.anthony.conceal.dao;


import com.anthony.conceal.dto.UserDTO;

import java.util.List;

/**
 * Created by Anthony on 2016/12/22.
 */
public interface UserMapper {
    String userLogin(String userName);
    String getUserIdByUserName(String userName);
    List<UserDTO> getAllUser();




}
