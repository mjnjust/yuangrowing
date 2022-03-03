package com.mj.yuangrowing.jdk.concurrent.aclh;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @Author maojun
 * @Date 2022/2/25
 */
public class AclhTest {

    public static void main(String[] args) throws Exception {
        System.out.println("-------------------");
        test_normalDequeue(5);
    }

    public static void test_normalDequeue(int num) throws Exception {
        NormalDequeue normalDequeue = new NormalDequeue();
        CountDownLatch countDownLatch = new CountDownLatch(num);
        for (int i = 0; i < num; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                normalDequeue.put(new Node(finalI));
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        normalDequeue.print();
    }

}
