package com.wodespacito.my_blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

@Configuration
public class RabbitMQConfig {
    private final static String TOKEN_VALIDATION_QUEUE = "tokenValidationQueue";

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean(name=TOKEN_VALIDATION_QUEUE)
    public Queue tokenValidationQueue(){
        return new Queue(TOKEN_VALIDATION_QUEUE);
    }
}
