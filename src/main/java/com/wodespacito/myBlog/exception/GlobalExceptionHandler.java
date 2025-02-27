package com.wodespacito.myBlog.exception;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wodespacito.myBlog.pojo.Response;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response<String> handleException(Exception e) {
        return Response.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "系统异常");
    }
}
