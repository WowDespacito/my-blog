package com.wowdespacito.my_blog.controller;

import org.springframework.web.bind.annotation.RestController;

import com.wowdespacito.my_blog.pojo.Blog;
import com.wowdespacito.my_blog.pojo.BlogListItem;
import com.wowdespacito.my_blog.pojo.PageBean;
import com.wowdespacito.my_blog.pojo.Response;
import com.wowdespacito.my_blog.service.BlogService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;
    // 获取博客列表
    @GetMapping("/getList")
    public Response<PageBean<BlogListItem>> getBlogList(
        Integer pageNum,
        Integer pageSize,
        @RequestParam(required = false) Integer status
    ) {
        return Response.success(blogService.getBlogList(pageNum, pageSize, status));
    }
    
    // 获取博客详情
    @GetMapping("/getDetail")
    public Response<Blog> getBlogDetail(@RequestParam(required = true) Integer id) {
        return Response.success(blogService.getBlogDetail(id));
    }
}
