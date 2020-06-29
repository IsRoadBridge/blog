package com.zxq.service.impl;

import com.zxq.dao.TypeMapper;
import com.zxq.pojo.Type;
import com.zxq.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> findAll() {
        List<Type> types = typeMapper.findAll();
        return types;
    }

    @Override
    public List<Type> findByTop() {
        return typeMapper.findByTop();
    }

    @Override
    public Type findById(Long id) {
        Type type = typeMapper.findById(id);
        return type;
    }

    @Override
    public Type findByName(String name) {
        Type type = typeMapper.findByName(name);
        return type;
    }

    @Override
    public int save(String name) {
        int i = typeMapper.save(name);
        return i;
    }

    @Override
    public int delete(Long id) {
        int i = typeMapper.delete(id);
        return i;
    }

    @Override
    public int update(Type type) {
        int i = typeMapper.update(type);
        return i;
    }
}
