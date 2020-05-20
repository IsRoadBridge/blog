package com.zxq.dao;

import com.zxq.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper {

    List<Tag>  findAll();

    Tag findById(Long id);

    Tag findByName(String name);

    int  save(String name);

    int delete(Long id);

    int update(Tag tag);


}
