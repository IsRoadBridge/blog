package com.zxq.dao;

import com.zxq.pojo.Tag;
import com.zxq.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeMapper {

    List<Type>  findAll();

    Type findById(Long id);

    Type findByName(String name);

    int  save(String name);

    int delete(Long id);

    int update(Type type);


}
