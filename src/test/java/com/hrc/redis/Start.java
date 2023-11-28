package com.hrc.redis;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class Start {

    @Resource
    private RedisTemplate redisTemplate;


}
