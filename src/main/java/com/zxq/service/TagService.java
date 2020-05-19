package com.zxq.service;

import com.zxq.pojo.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findAll();

    Tag findById(Long id);

    int save(String name);

    int delete(Long id);

    int update(Tag tag);
}
