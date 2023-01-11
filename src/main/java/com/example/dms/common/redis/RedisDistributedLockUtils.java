package com.example.dms.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouy
 * @date 2021/12/20
 * good 单机版
 */
public class RedisDistributedLockUtils {
   /* @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean getLock(String key ,long time){
        Boolean flag = redisTemplate.opsForValue().setIfAbsent(key, null, time, TimeUnit.MILLISECONDS);
        return flag;
    }

    public void releaseLock(String key){
        redisTemplate.delete(key);
    }*/
}
