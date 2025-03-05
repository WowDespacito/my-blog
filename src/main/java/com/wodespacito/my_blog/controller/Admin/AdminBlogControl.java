package com.wodespacito.my_blog.controller.Admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wodespacito.my_blog.pojo.Blog;
import com.wodespacito.my_blog.service.BlogService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/admin")
public class AdminBlogControl {
    private BlogService blogService;

    @PostMapping("/addBlog")
    public void add(@RequestBody Blog blog) {
        System.err.println(blog);
        blogService.addBlog(blog);
    }

    @PutMapping("/updateBlog")
    public void update(@RequestBody Blog blog) {
        blogService.updateBlog(blog);
    }
    
    @DeleteMapping("/deleteBlog")
    public void delete(Integer id) {
        blogService.deleteBlog(id);
    }
}
