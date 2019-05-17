package com.sunyt.mindcoll.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestRedis {

    public void testConnRedis(){
        Jedis jedis = new Jedis("IP",6379);
        jedis.auth("redis123");
        jedis.set("username", "");
        System.out.println("redis username ---" + jedis.clientGetname());
    }

    public void testRedisPool(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(50);
        poolConfig.setMaxIdle(10);
        poolConfig.setMaxTotal(30);
        JedisPool jedisPool = new JedisPool(poolConfig, "IP", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.auth("redis123");
        //存储成key-value型的数据
        jedis.set("","");
        //查看是否存储完毕
        System.out.println(jedis.get(""));
        //连接池不用关闭，只关闭资源。
        jedis.close();
        //多个对象，如何存储值，相互关系。
    }
}
