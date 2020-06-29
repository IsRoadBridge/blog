package com.zxq.dao;

import com.zxq.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User findUserByUsernameAndPassword(String username,String password);

    User findUserById(Long id);

}
