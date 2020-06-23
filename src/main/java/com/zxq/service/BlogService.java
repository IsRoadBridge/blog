package com.zxq.service;

import com.zxq.pojo.Blog;

import java.util.List;

public interface BlogService {

    List<Blog> findBlogAll();

    Blog findById(Long id);

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);

    int deleteBlog(Long id);
}
