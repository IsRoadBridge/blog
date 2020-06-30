package com.zxq.service;

import com.zxq.pojo.Blog;

import java.text.ParseException;
import java.util.List;

public interface BlogService {

    List<Blog> findBlogAll();

    List<Blog> findBlogBySearch(String query);

    List<Blog> findBlogByTypeId(Long typeId);

    Blog findById(Long id);

    List<Blog>  findBlogTop(Integer size);

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);

    int deleteBlog(Long id);
}
