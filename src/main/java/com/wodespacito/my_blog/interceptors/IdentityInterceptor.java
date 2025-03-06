package com.wodespacito.my_blog.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import com.wodespacito.my_blog.producer.TokenValidationProducer;
import com.wodespacito.my_blog.utils.ThreadLoaclUtil;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@Component
public class IdentityInterceptor implements HandlerInterceptor{
    @Autowired
    private TokenValidationProducer tokenValidationProducer;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,@NonNull Object handler) throws Exception {
        // 获取请求头中的token
        String token = request.getHeader("Authorization");
        System.out.println(token);
        // 校验token
        try {
            boolean result = tokenValidationProducer.validateToken(token);
            System.out.println("验证结果："+ result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, @Nullable Exception ex) throws Exception {
        // 清除ThreadLocal中的用户信息
        ThreadLoaclUtil.remove();
    }
}
