package com.hrc.redis.value;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class StringTest {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void add() {
        // 1、通过redisTemplate设置值
        redisTemplate.boundValueOps("StringKey").set("StringValue");
        redisTemplate.boundValueOps("StringKey").set("StringValue", 1, TimeUnit.MINUTES);

        // 2、通过BoundValueOperations设置值
        BoundValueOperations stringKey = redisTemplate.boundValueOps("StringKey");
        stringKey.set("StringValue");
        stringKey.set("StringValue", 1, TimeUnit.MINUTES);

         // 3、通过ValueOperations设置值
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("StringKey", "StringValue");
        ops.set("StringValue", "StringValue", 1, TimeUnit.MINUTES);

    }

    @Test
    public void expire() {
        redisTemplate.boundValueOps("StringKey").expire(Duration.ofSeconds(1));
        redisTemplate.expire("StringKey", Duration.ofSeconds(1));
    }

    @Test
    public void get() {
        //1、通过redisTemplate获取值
        System.out.println(redisTemplate.boundValueOps("StringKey").get());

        //2、通过BoundValueOperations获取值
        BoundValueOperations stringKey = redisTemplate.boundValueOps("StringKey");
        StringTest str2 = (StringTest) stringKey.get();
        System.out.println(str2);

        //3、通过ValueOperations获取值
        ValueOperations ops = redisTemplate.opsForValue();
        StringTest str3 = (StringTest) ops.get("StringKey");
        System.out.println(str3);
    }

    @Test
    public void increment() {
        System.out.println(redisTemplate.opsForValue().increment("key1", 3L));
        System.out.println(redisTemplate.opsForValue().increment("key1", -3l));
        System.out.println(redisTemplate.boundValueOps("StringKey").increment(3L));
        System.out.println(redisTemplate.boundValueOps("StringKey").increment(-3L));
    }

}
