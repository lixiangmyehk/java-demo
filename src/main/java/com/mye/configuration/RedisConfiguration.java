package com.mye.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisConfiguration {

    @Value("${app.redis.host}")
    private String redisHost;
    @Value("${app.redis.port}")
    private Integer redisPort;
    @Value("${app.redis.timeout}")
    private Integer timeout;
    @Value("${app.redis.maxTotal}")
    private Integer maxTotal;
    @Value("${app.redis.expire}")
    private Integer redisExpire;

    @Bean(name = "jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(200);
        jedisPoolConfig.setNumTestsPerEvictionRun(1024);
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(30000);
        jedisPoolConfig.setMinEvictableIdleTimeMillis(-1);
        jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(10000);
        jedisPoolConfig.setMaxWaitMillis(1500);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestWhileIdle(true);
        jedisPoolConfig.setTestOnReturn(false);
        jedisPoolConfig.setJmxEnabled(true);
        jedisPoolConfig.setBlockWhenExhausted(false);
        return jedisPoolConfig;
    }

    @Bean("jedisSentinelPool")
    public JedisSentinelPool jedisSentinelPool(){

        Set<String> sentinels = new HashSet<>();
        String hostAndPort = redisHost + ":" + redisPort;
        sentinels.add(hostAndPort);

        return new JedisSentinelPool("mymaster", sentinels, jedisPoolConfig());


    }







}
