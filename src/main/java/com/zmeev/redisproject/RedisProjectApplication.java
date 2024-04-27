package com.zmeev.redisproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.thehecklers.planefinder.Aircraft;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
public class RedisProjectApplication {

    ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    public RedisOperations<String, Aircraft> redisOperations(RedisConnectionFactory connectionFactory) {
        objectMapper.registerModule(new JavaTimeModule());
        Jackson2JsonRedisSerializer<Aircraft> serializer = new Jackson2JsonRedisSerializer<>(objectMapper, Aircraft.class);
        RedisTemplate<String, Aircraft> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setDefaultSerializer(serializer);
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }
    public static void main(String[] args) {
        SpringApplication.run(RedisProjectApplication.class, args);
    }

}
