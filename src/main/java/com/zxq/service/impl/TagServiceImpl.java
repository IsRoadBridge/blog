package com.zxq.service.impl;

import com.zxq.dao.TagMapper;
import com.zxq.pojo.Tag;
import com.zxq.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> findAll() {
        List<Tag> tags = tagMapper.findAll();
        return tags;
    }

    @Override
    public Tag findById(Long id) {
        Tag tag = tagMapper.findById(id);
        return tag;
    }

    @Override
    public int save(String name) {
        int i = tagMapper.save(name);
        return i;
    }

    @Override
    public int delete(Long id) {
        int i = tagMapper.delete(id);
        return i;
    }

    @Override
    public int update(Tag tag) {
        int i = tagMapper.update(tag);
        return i;
    }
}
