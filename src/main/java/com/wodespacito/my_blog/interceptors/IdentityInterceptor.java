package com.wodespacito.my_blog.interceptors;

import java.util.Map;

import org.springframework.web.servlet.HandlerInterceptor;

import com.wodespacito.my_blog.utils.JWTUtil;
import com.wodespacito.my_blog.utils.ThreadLoaclUtil;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.lang.NonNull;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@Component
public class IdentityInterceptor implements HandlerInterceptor{
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,@NonNull Object handler) throws Exception {
        // 获取请求头中的token
        String token = request.getHeader("Authorization");
        // 校验token
        try {
            Map<String, Object> claims = JWTUtil.parseToken(token);

            // 从redis中获取用户信息
            String redisToken = stringRedisTemplate.opsForValue().get("user_"+claims.get("id"));
            if (redisToken == null || !redisToken.equals(token)) {
                throw new Exception("请重新登录");
            }

            // 保存用户信息到ThreadLocal
            ThreadLoaclUtil.set(claims);

            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex) throws Exception {
        // 清除ThreadLocal中的用户信息
        ThreadLoaclUtil.remove();
    }
}
