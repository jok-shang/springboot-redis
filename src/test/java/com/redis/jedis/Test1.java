package com.redis.jedis;


import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.*;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @auther 尚智江
 * @Date 2023/5/16 18:19
 */
@SpringBootTest
public class Test1 {
    @Resource
    private RedisTemplate redisTemplate;

   @Test
    public void a(){
//       redisTemplate.opsForValue().set("a","aa");
       System.out.println(redisTemplate.opsForValue().get("a"));
//        JedisConfig jedisConfig = new JedisConfig();
//        System.out.println(jedisConfig.getHost());
    }

    @Test
    public void jedis(){
        //1.生成一个Jedis对象，这个对象负责和指定的Redis节点进行通信
        Jedis jedis = new Jedis("localhost",6379);
        //2.jedis执行set操作
//        jedis.set("hello","world");
        //3.jedis执行get操作，value=“world”
        System.out.println(jedis.get("hello"));
    }


}

