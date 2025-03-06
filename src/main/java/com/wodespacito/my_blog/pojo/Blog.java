package com.wodespacito.my_blog.pojo;

import lombok.Data;

import java.time.LocalDateTime;

import com.wodespacito.my_blog.anno.Status;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;

@Data
public class Blog {
    @NotNull(groups = Update.class)
    private Integer id;
    @NotNull
    private String title;
    // content 字段用于存储 Markdown 内容
    private String content;
    private String author = "咫";
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @Status
    private int status;

    public interface Update extends Default {

    }
}
