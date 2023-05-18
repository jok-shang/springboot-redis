package com.redis.jedis;

import com.redis.jedis.util.RedisCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 尚智江
 * @Date 2023/5/18 21:44
 */
@SpringBootTest
public class RedisCacheTest {


    @Resource
    private RedisCache redisCache;


    @Test
    public void getKey(){
        Object a = redisCache.getCacheObject("a");
        System.out.println(a);
    }

    /*
         * 缓存基本的对象，Integer、String、实体类等
         *  不带时间
         * @param key 缓存的键值
         * @param value 缓存的值

    public <T> void setCacheObject(final String key, final T value)
    {
        redisTemplate.opsForValue().set(key, value);
    }
     */
    @Test
    public void setRedisCache(){
        redisCache.setCacheObject("a","不带时间");
        Object a = redisCache.getCacheObject("a");
        System.out.println(a);
    }
    /*
         * 缓存基本的对象，Integer、String、实体类等
         *  带时间
         * @param key 缓存的键值
         * @param value 缓存的值
         * @param timeout 时间
         * @param timeUnit 时间颗粒度
    public <T> void setCacheObject(final String key, final T value, final Integer timeout, final TimeUnit timeUnit)
    {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }
     */
    @Test
    public void setRedisCacheTime(){
        // 存在三秒
//        redisCache.setCacheObject("aa","带时间",3,TimeUnit.SECONDS);
        Object a = redisCache.getCacheObject("a");
        System.out.println(a);
    }

    /*

   插入list测试
     */
    @Test
    public void setRedisCacheList(){
        List<String> list = new ArrayList<>();
        for (int i = 0;i<10;i++){
            list.add(i,"插入list测试");
        }
        redisCache.setCacheList("list",list);
        List<Object> list1 = redisCache.getCacheList("list");
        System.out.println(list1);
    }


    /*
    删除list测试
     */
    @Test
    public void deleteList(){
        redisCache.deleteObject("list");
        List<Object> list = redisCache.getCacheList("list");
        System.out.println(list);
    }

    /*
    插入map测试
     */
    @Test
    public void setMap(){
        HashMap<String,String> map = new HashMap<>();
        for (int i = 0 ;i<10 ;i++){
            map.put("map"+i,"插入map测试");
        }
        redisCache.setCacheMap("map",map);
        Map<String, Object> map1 = redisCache.getCacheMap("map");
        System.out.println(map1);
    }
    @Test
    public void getMap(){
        Map<String, Object> map = redisCache.getCacheMap("map");
        System.out.println(map);
    }
    /*
    删除map测试
    传入 redis的key  和map的key
     */
    @Test
    public void deleteMap(){
        redisCache.delCacheMapValue("map","map2");
        Map<String, Object> map = redisCache.getCacheMap("map");
        System.out.println(map);
    }
}
