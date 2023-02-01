package com.mj.learn.jvm.concurrent;

import lombok.SneakyThrows;

/**
 * 等待通知的经典写法
 */
public class WaitAndNotify {

    public static Boolean flag = false;

    public final static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        /**
         * 消费方
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 加同步块
                synchronized (lock) {
                    // 不断判断标志
                    while (!flag) {
                        try {
                            // 标志不对，则等待，即使锁释放了还应该再判断标志位
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("flag is " + flag);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("prepare to set flag");
                Thread.sleep(2000);
                // 加同步块
                synchronized (lock) {
                    // 改标志位
                    flag = true;
                    // 唤醒
                    lock.notify();
                }
            }
        }).start();

        Thread.sleep(5000);
    }
}
