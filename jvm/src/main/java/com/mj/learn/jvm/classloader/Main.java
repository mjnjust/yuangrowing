//package com.mj.learn.dubbo.simulate.api;
//
//import org.redisson.Redisson;
//import org.redisson.api.RBlockingQueue;
//import org.redisson.config.Config;
//
//import java.util.concurrent.TimeUnit;
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://117.62.217.89:6379").setPassword("Maojun2855");
//        var redis = Redisson.create(config);
//        RBlockingQueue<Asc> a = redis.getBlockingQueue("test");
//        System.out.println(a.poll(1, TimeUnit.DAYS).getA());
//    }
//}
