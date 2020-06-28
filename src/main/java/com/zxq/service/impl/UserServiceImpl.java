package com.zxq.service.impl;

import com.zxq.dao.UserMapper;
import com.zxq.pojo.User;
import com.zxq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUsernameAndPassword(String username,String password) {
        User user =userMapper.findUserByUsernameAndPassword(username,password);
        return user;
    }

}
