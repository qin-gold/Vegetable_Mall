//package com.shop.utils;
//
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//import java.io.InputStream;
//import java.util.Properties;
//
///**
// * JedisPool工具类
// *   加载配置文件，配置连接池的参数
// *   提供获取连接的方法
// */
//public class JedisPoolUtils {
//    private static JedisPool jedisPool;
//    static {
//        //读取配置文件
//        InputStream resourceAsStream = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
//        //创建properties对象
//        Properties properties=new Properties();
//        //关联文件
//        try{
//            properties.load(resourceAsStream);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        JedisPoolConfig config=new JedisPoolConfig();
//        config.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
//        config.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
//        //初始化JedisPool
//        jedisPool=new JedisPool(config,properties.getProperty("host"), Integer.parseInt(properties.getProperty("port")));
//    }
//    /**
//     * 获取连接方法
//     */
//    public static Jedis getJedis(){
//        return jedisPool.getResource();
//    }
//}