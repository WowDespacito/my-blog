package com.wodespacito.myBlog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wodespacito.myBlog.pojo.Blog;

@Mapper
public interface BlogMapper {
    List<Blog> getBlogList(Integer status);
    Blog getBlogDetail(Integer id);
    void addBlog(Blog blog);
    void updateBlog(Blog blog);
    void deleteBlog(Integer id);
}
