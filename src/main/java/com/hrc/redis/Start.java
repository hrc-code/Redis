package com.hrc.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootApplication
public class Start {
    @Resource
    private RedisTemplate redisTemplate;
    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }
}
