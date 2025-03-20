package com.wowdespacito.my_blog.controller.Admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wowdespacito.my_blog.pojo.Blog;
import com.wowdespacito.my_blog.pojo.Response;
import com.wowdespacito.my_blog.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/admin/blog")
public class AdminBlogControl {
    private static final Logger logger = LoggerFactory.getLogger(AdminBlogControl.class);

    @Autowired
    private BlogService blogService;

    @PostMapping("/addBlog")
    public Response<String> add(@RequestBody Blog blog) {
        logger.info("新增blog：" + blog.getTitle());
        blogService.addBlog(blog);
        logger.info("新增blog成功" + blog.getTitle());
        return Response.success();
    }

    @PutMapping("/updateBlog")
    public Response<String> update(@RequestBody @Validated(Blog.Update.class) Blog blog) {
        logger.info("更新blog：" + blog.getId().toString());
        blogService.updateBlog(blog);
        logger.info("更新blog成功");
        return Response.success();
    }

    @DeleteMapping("/deleteBlog/{id}")
    public Response<String> delete(@PathVariable Integer id) {
        logger.info("移除blog：id=" + id.toString());
        blogService.deleteBlog(id);
        logger.info("移除blog成功");
        return Response.success();
    }
}
