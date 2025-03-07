package com.wowdespacito.my_blog.pojo;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response<T> {
    private String code;
    private String message;
    private T data;
    
    // 快速返回操作成功响应结果(带data)
    public static <E> Response<E> success(E data){
        return new Response<E>("SSSS", "操作成功", data);
    }

    // 快速返回操作成功响应结果
    public static <E> Response<E> success(){
        return new Response<E>("SSSS", "操作成功", null);
    }

    // 快速返回操作失败响应结果
    public static <E> Response<E> error(String message){
        return new Response<E>("FFFF", message, null);
    } 
}
