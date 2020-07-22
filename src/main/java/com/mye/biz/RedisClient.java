package com.mye.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.List;
import java.util.Set;

@Component
public class RedisClient {

    @Autowired
    private JedisSentinelPool jedisSentinelPool;


    public String set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisSentinelPool.getResource();
            return jedis.set(key, value);
        } finally {
            //返还到连接池
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    public long remove(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisSentinelPool.getResource();
            return jedis.del(key);
        } finally {
            //返还到连接池
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    public String setEx(String key, String value, int time) {
        Jedis jedis = null;
        try {
            jedis = jedisSentinelPool.getResource();
            return jedis.setex(key, time,value);
        } finally {
            //返还到连接池
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    public String get(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisSentinelPool.getResource();
            return jedis.get(key);
        } finally {
            //返还到连接池
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    public Set<String> keys(String parttern) {
        Jedis jedis = null;
        try {
            jedis = jedisSentinelPool.getResource();
            return jedis.keys(parttern);
        } finally {
            //返还到连接池
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    public Long setExpire(String key, int time) {
        Jedis jedis = null;
        try {
            jedis = jedisSentinelPool.getResource();
            return jedis.expire(key, time);
        } finally {
            //返还到连接池
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    public void  list(String key, String value){
        Jedis jedis = null;
        try {
            jedis = jedisSentinelPool.getResource();
            jedis.rpush(key,value);
        } finally {
            //返还到连接池
            if(jedis!=null){
                jedis.close();
            }
        }

    }

    public List<String> readList(String key, long start, long end){
        Jedis jedis = null;
        try {
            jedis = jedisSentinelPool.getResource();
            return jedis.lrange(key,start, end);
        } finally {
            //返还到连接池
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    public long readlen(String key){
        Jedis jedis = null;
        try {
            jedis = jedisSentinelPool.getResource();
            return jedis.llen(key);
        } finally {
            //返还到连接池
            if(jedis!=null){
                jedis.close();
            }
        }
    }



    public JedisSentinelPool getJedisSentinelPool() {
        return jedisSentinelPool;
    }

    public void setJedisSentinelPool(JedisSentinelPool jedisSentinelPool) {
        this.jedisSentinelPool = jedisSentinelPool;
    }

}
