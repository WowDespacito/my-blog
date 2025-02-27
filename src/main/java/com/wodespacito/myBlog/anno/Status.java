package com.wodespacito.myBlog.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import com.wodespacito.myBlog.validation.StatusValidation;

import java.lang.annotation.Documented;

@Documented // 说明该注解将被包含在javadoc中
@Retention(RetentionPolicy.RUNTIME) // 说明该注解将被保留到什么阶段
@Target(ElementType.FIELD) // 说明该注解将被声明在哪些元素之前
@Constraint(validatedBy = {
    StatusValidation.class
}) // 说明该注解将被用于声明一个约束
public @interface Status {
    
}
