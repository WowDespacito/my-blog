package com.wowdespacito.my_blog.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.wowdespacito.my_blog.validation.StatusValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;

@Documented // 说明该注解将被包含在javadoc中
@Retention(RetentionPolicy.RUNTIME) // 说明该注解将被保留到什么阶段
@Target(ElementType.FIELD) // 说明该注解将被声明在哪些元素之前
@Constraint(validatedBy = {
    StatusValidation.class
}) // 说明该注解将被用于声明一个约束
public @interface Status {
    // 提供校验失败后的提示信息
    String message() default "status参数的值只能是字典中规定的值";

    // 指定分组
    Class<?>[] groups() default {};
    
    //负载 获取到Status注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
