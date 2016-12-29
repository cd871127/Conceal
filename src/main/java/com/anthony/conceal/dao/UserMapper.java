package com.anthony.conceal.dao;


import com.anthony.conceal.dto.UserDTO;

/**
 * Created by Anthony on 2016/12/22.
 */
public interface UserMapper {
    UserDTO getUserDTObyUserName(String userName);
//    String getUserIdByUserName(String userName);
//    List<UserDTO> getAllUser();

}
