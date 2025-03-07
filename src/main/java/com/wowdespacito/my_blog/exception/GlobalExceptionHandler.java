package com.wowdespacito.my_blog.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wowdespacito.my_blog.pojo.Response;

import org.springframework.web.bind.MissingServletRequestParameterException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Response<String> handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        logger.error("Missing request parameter: {}", name);
        return Response.error(name + " parameter is missing");
    }

    @ExceptionHandler(Exception.class)
    public Response<String> handleException(Exception e) {
        logger.error("Exception caught: ", e);
        return Response.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "系统异常");
    }
}
