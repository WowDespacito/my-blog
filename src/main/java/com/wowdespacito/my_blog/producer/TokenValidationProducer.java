package com.wowdespacito.my_blog.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wowdespacito.my_blog.exception.MyException;

@Component
public class TokenValidationProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public boolean validateToken(String token) throws MyException{
        System.out.println(token);
        Object response = amqpTemplate.convertSendAndReceive("tokenValidationQueue",token);
        if (response!=null){
            return (boolean) response;
        }else{
            throw new MyException("验证异常");
        } 
    }
}
