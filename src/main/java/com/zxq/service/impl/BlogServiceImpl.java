package com.zxq.service.impl;

import com.zxq.dao.BlogMapper;
import com.zxq.pojo.Blog;
import com.zxq.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Blog> findBlogAll() {
        return blogMapper.findBlogAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogMapper.findById(id);
    }

    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        return blogMapper.saveBlog(blog);
    }

    @Override
    public int updateBlog(Blog blog) {
        blog.setUpdateTime(new Date());
        return blogMapper.updateBlog(blog);
    }

    @Override
    public int deleteBlog(Long id) {
        return blogMapper.deleteBlog(id);
    }
}
