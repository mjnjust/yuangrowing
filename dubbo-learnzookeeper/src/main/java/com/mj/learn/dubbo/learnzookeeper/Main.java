package com.mj.learn.dubbo.learnzookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws Exception {
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder().namespace("MyApp").connectString("117.62.217.89:2181").retryPolicy(retryPolicy).build();
        client.start();
        String path = "/test";
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client, path, true);
        pathChildrenCache.start();

        CountDownLatch latch = new CountDownLatch(10);
        new Thread(() -> {
            PathChildrenCacheListener listener = (curatorFramework, event) -> {
                switch (event.getType()) {
                    case CHILD_ADDED:
                        String data = new String(event.getData().getData());
                        System.out.println("add: " + data);
                        latch.countDown();
                        break;
                    case CHILD_UPDATED:
                        data = new String(event.getData().getData());
                        System.out.println("update: " + data);
                        latch.countDown();
                        break;
                    case CHILD_REMOVED:
                        data = new String(event.getData().getData());
                        System.out.println("remove: " + data);
                        latch.countDown();
                        break;
                }
            };
            pathChildrenCache.getListenable().addListener(listener);
        }).start();
        latch.await();
        client.close();
    }
}
