package com.wowdespacito.my_blog.pojo;

import lombok.Data;

import java.time.LocalDateTime;

import com.wowdespacito.my_blog.anno.Status;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

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

    @PreUpdate
    protected void onUpdate(){
        updateTime = LocalDateTime.now();
    }

    @PrePersist
    protected void onCreate(){
        createTime = LocalDateTime.now();
    }

    public interface Update extends Default {

    }
}
