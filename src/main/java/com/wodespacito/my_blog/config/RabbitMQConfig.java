package com.wodespacito.my_blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {
    private final static String TOKEN_VALIDATION_QUEUE = "tokenValidationQueue";

    @Bean(name=TOKEN_VALIDATION_QUEUE)
    public Queue tokenValidationQueue(){
        return new Queue(TOKEN_VALIDATION_QUEUE);
    }
}
