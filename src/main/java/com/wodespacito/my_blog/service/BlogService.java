package com.wodespacito.my_blog.service;

import com.wodespacito.my_blog.pojo.Blog;
import com.wodespacito.my_blog.pojo.BlogListItem;
import com.wodespacito.my_blog.pojo.PageBean;

public interface BlogService {
    // 获取博客列表
    PageBean<BlogListItem> getBlogList(Integer pageNum, Integer pageSize, Integer status);
    
    // 获取博客详情
    Blog getBlogDetail(Integer id);
    
    // 新增博客
    void addBlog(Blog blog);

    // 更新博客
    void updateBlog(Blog blog);

    // 删除博客
    void deleteBlog(Integer id);
}
