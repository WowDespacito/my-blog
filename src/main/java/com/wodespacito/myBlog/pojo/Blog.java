package com.wodespacito.myBlog.pojo;

import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class Blog {
    @NotNull
    private Integer id;
    @NotNull
    private String title;
    // content 字段用于存储 Markdown 内容
    private String content;
    @Builder.Default 
    private String author = "咫";
    private String createTime;
    private String updateTime;
    private Integer status;
}
