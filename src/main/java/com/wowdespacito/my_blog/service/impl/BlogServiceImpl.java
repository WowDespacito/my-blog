package com.wowdespacito.my_blog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wowdespacito.my_blog.mapper.BlogMapper;
import com.wowdespacito.my_blog.pojo.Blog;
import com.wowdespacito.my_blog.pojo.BlogListItem;
import com.wowdespacito.my_blog.pojo.PageBean;
import com.wowdespacito.my_blog.service.BlogService;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    private static final Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);

    // 获取博客列表
    @Override
    public PageBean<BlogListItem> getBlogList(
        Integer pageNum,
        Integer pageSize,
        Integer status
    ) {
        // 创建pageBean对象
        PageBean<BlogListItem> bp = new PageBean<>();

        // 开启分页查询
        PageHelper.startPage(pageNum, pageSize);

        // 调用Mapper查询数据
        try (Page<BlogListItem> page =(Page<BlogListItem>) blogMapper.getBlogList(status)){
            bp.setTotal(page.getTotal());
            bp.setItems(page.getResult());
        } catch(Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return bp;
    }
    
    // 获取博客详情
    public Blog getBlogDetail(Integer id) {
        return blogMapper.getBlogDetail(id);
    }
    
    // 新增博客
    public void addBlog(Blog blog) {
        blog.setCreateTime(LocalDateTime.now());
        blog.setUpdateTime(LocalDateTime.now());
        blog.setStatus(0);
        blogMapper.addBlog(blog);
    }

    // 更新博客
    public void updateBlog(Blog blog) {
        blogMapper.updateBlog(blog);
    }

    // 删除博客
    public void deleteBlog(Integer id) {
        blogMapper.deleteBlog(id);
    }
}
