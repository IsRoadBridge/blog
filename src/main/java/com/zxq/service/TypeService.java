package com.zxq.service;

import com.zxq.pojo.Type;

import java.util.List;

public interface TypeService {


    List<Type> findAll();

    List<Type>  findByTop();

    Type findById(Long id);

    Type findByName(String name);

    int save(String name);

    int delete(Long id);

    int update(Type type);
}
