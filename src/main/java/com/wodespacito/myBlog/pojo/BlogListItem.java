package com.wodespacito.myBlog.pojo;

import lombok.Data;

@Data
public class BlogListItem {
    private Integer id;
    private String title;
    private String author;
    private String createTime;
    private String updateTime;
    private Integer status;
}
