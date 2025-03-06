package com.wodespacito.my_blog.controller.Admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wodespacito.my_blog.pojo.Blog;
import com.wodespacito.my_blog.pojo.Response;
import com.wodespacito.my_blog.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/admin")
public class AdminBlogControl {
    @Autowired
    private BlogService blogService;

    @PostMapping("/addBlog")
    public Response<String> add(@RequestBody @Validated Blog blog) {
        System.err.println(blog);
        blogService.addBlog(blog);
        return Response.success();
    }

    @PutMapping("/updateBlog")
    public Response<String> update(@RequestBody Blog blog) {
        blogService.updateBlog(blog);
        return Response.success();
    }
    
    @DeleteMapping("/deleteBlog")
    public Response<String> delete(Integer id) {
        blogService.deleteBlog(id);
        return Response.success();
    }
}
