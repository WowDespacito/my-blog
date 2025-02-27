package com.wodespacito.myBlog.controller;

import org.springframework.web.bind.annotation.RestController;

import com.wodespacito.myBlog.pojo.Blog;
import com.wodespacito.myBlog.pojo.PageBean;
import com.wodespacito.myBlog.pojo.Response;
import com.wodespacito.myBlog.service.BlogService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    // 获取博客列表
    @GetMapping("/getList")
    public Response<PageBean<Blog>> getBlogList(
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
