package com.zxq.service;

import com.zxq.pojo.User;

public interface UserService {

    User findUserByUsernameAndPassword(String username,String password);
}
