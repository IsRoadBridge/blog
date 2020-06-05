package com.zxq.dao;

import com.zxq.pojo.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper {

    List<Blog> findBlogAll();

    Blog findById(Long id);

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);

    int deleteBlog(Long id);

}
