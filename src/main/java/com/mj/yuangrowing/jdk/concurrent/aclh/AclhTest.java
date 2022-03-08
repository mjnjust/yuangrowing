package com.mj.yuangrowing.jdk.concurrent.aclh;

import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @Author maojun
 * @Date 2022/2/25
 */
public class AclhTest {

    public static void main(String[] args) {
        System.out.println("-------------------");
        test_queue(new NormalDequeue(), 5);
        test_queue(new ClhDequeue(), 5);
    }

    public static void test_queue(AbstractDequeue<Integer> queue, int num) {
        try {
            CountDownLatch countDownLatch = new CountDownLatch(num);
            for (int i = 0; i < num; i++) {
                int finalI = i;
                new Thread(() -> {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    queue.put(new Node(finalI));
                    countDownLatch.countDown();
                }).start();
            }
            countDownLatch.await();
            queue.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
