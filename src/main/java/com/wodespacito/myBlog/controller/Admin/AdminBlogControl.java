package com.wodespacito.myBlog.controller.Admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wodespacito.myBlog.pojo.Blog;
import com.wodespacito.myBlog.service.BlogService;

import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/admin/blog")
public class AdminBlogControl {
    private BlogService blogService;

    @PostMapping("/add")
    public void add(@RequestBody Blog blog) {
        blogService.addBlog(blog);
    }

    @Update("/update")
    public void update(@RequestBody Blog blog) {
        blogService.updateBlog(blog);
    }
    
}
