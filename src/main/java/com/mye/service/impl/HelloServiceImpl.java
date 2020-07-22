package com.mye.service.impl;

import com.mye.biz.RedisClient;
import com.mye.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    RedisClient redisClient;

    public String Say(){
        return "hello world!";
    }

    @Override
    public String result() {
        Set<String> keys = redisClient.keys("*");
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : keys) {
            stringBuilder.append(key).append(":").append(redisClient.get(key)).append("\n");
        }
        return stringBuilder.toString();
    }

}
