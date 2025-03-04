package com.wodespacito.my_blog.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JWTUtil {
    private static final String KEY = System.getenv("JWT_KEY");

    //接收业务数据，生成token并返回
    public static String getToken(Map<String, Object> claims){
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis()+60*60))
                .sign(Algorithm.HMAC256(KEY));
    }

    //接收验证token，验证token，并返回业务数据
    public static Map<String, Object> parseToken(String token){
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
