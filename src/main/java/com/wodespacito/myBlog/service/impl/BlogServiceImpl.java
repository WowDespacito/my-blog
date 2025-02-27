package com.wodespacito.myBlog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wodespacito.myBlog.mapper.BlogMapper;
import com.wodespacito.myBlog.pojo.Blog;
import com.wodespacito.myBlog.pojo.PageBean;
import com.wodespacito.myBlog.service.BlogService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    // 获取博客列表
    @Override
    public PageBean<Blog> getBlogList(
        Integer pageNum,
        Integer pageSize,
        Integer status
    ) {
        // 创建pageBean对象
        PageBean<Blog> bp = new PageBean<>();

        // 开启分页查询
        PageHelper.startPage(pageNum, pageSize);

        // 调用Mapper查询数据
        List<Blog> list = blogMapper.getBlogList(status);
        try (Page<Blog> page = (Page<Blog>) list){
            bp.setTotal(page.getTotal());
            bp.setItems(page.getResult());
        } catch(Exception e) {
            e.printStackTrace();
        }

        return bp;
    }
    
    // 获取博客详情
    public Blog getBlogDetail(Integer id) {
        return blogMapper.getBlogDetail(id);
    }
    
    // 新增博客
    public void addBlog(Blog blog) {
        blogMapper.addBlog(blog);
    }

    // 更新博客
    public void updateBlog(Blog blog) {
        blogMapper.updateBlog(blog);
    }
}
