package com.wodespacito.my_blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {
    private final static String TOKEN_VALIDATION_QUEUE = "tokenValidationQueue";
    private static final String TOKEN_VALIDATION_RESPONSE_QUEUE = "tokenValidationResponseQueue";

    @Bean
    public Queue tokenValidationQueue(){
        return new Queue(TOKEN_VALIDATION_QUEUE);
    }

    @Bean
    public Queue tokenValidationResponseQueue(){
        return new Queue(TOKEN_VALIDATION_RESPONSE_QUEUE);
    }
}
