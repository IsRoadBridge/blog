package com.zxq.dao;

import com.zxq.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
@Repository
public interface BlogMapper {

    List<Blog> findBlogAll();

    List<Blog> findBlogBySearch(String query);

    List<Blog> findBlogByTypeId(Long typeId);

    List<String> findYears();

    List<Blog> findBlogByYears(String year);

    Blog findById(Long id);

    List<Blog>  findBlogTop(Integer size);

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);

    int deleteBlog(Long id);

}
