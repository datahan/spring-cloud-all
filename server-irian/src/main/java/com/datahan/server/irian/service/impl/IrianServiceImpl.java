package com.datahan.server.irian.service.impl;

import com.datahan.server.irian.service.IrianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.URL;

@Service
public class IrianServiceImpl implements IrianService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "redisTemplateCustom")
    private ListOperations<String, String> listOps;

    @Override
    public void addListByListOps(String userId, URL url) {
        listOps.leftPush(userId, url.toExternalForm());
    }

    @Override
    public void addListByStringRedisTemplate(String userId, URL url) {
        stringRedisTemplate.opsForList().leftPush(userId, url.toExternalForm());
        useCallback();
    }

    public void useCallback() {

        stringRedisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                Long size = connection.dbSize();
                // Can cast to StringRedisConnection if using a StringRedisTemplate
                ((StringRedisConnection)connection).set("key", "value");
                return null;
            }
        });
    }
}
