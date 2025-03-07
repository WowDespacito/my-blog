package com.wowdespacito.my_blog.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import com.wowdespacito.my_blog.producer.TokenValidationProducer;
import com.wowdespacito.my_blog.utils.ThreadLoaclUtil;

import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@Component
public class IdentityInterceptor implements HandlerInterceptor{

    private static final Logger logger = LoggerFactory.getLogger(IdentityInterceptor.class);

    @Autowired
    private TokenValidationProducer tokenValidationProducer;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,@NonNull Object handler) throws Exception {
        // 获取请求头中的token
        String token = request.getHeader("Authorization");
        logger.info("收到admin请求，待验证token："+token);
        // 校验token
        try {
            boolean result = tokenValidationProducer.validateToken(token);
            logger.info("验证结果："+ result);
            return result;
        } catch (Exception e) {
            logger.error("token："+token, e);;
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
