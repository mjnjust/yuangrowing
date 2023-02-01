package com.mj.learn.jvm.concurrent;

import lombok.SneakyThrows;

public class ThreadJoin {
    public static void main(String[] args) throws Exception {
        test1();
        System.out.println("---------------------------");
        test2();
        System.out.println("---------------------------");
        test3();
    }

    public static void test1() throws Exception {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI);
                }
            });
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        Thread.sleep(200);
    }

    public static Thread[] threads = new Thread[10];

    public static void test2() throws Exception {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threads[i] = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    if (finalI > 0) {
                        // 等上一个线程结束
                        threads[finalI - 1].join();
                    }
                    System.out.println(finalI);
                }
            });
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        Thread.sleep(200);
    }

    public static Thread[] threads3 = new Thread[10];
    public static Object lock3 = new Object();
    public static int flag = -1;


    public static void test3() throws Exception {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threads3[i] = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    synchronized (lock3) {
                        if (finalI == 0) {
                            System.out.println(finalI);
                        } else {
                            while (flag != finalI) {
                                lock3.wait();
                            }
                            System.out.println(finalI);
                        }
                        flag = finalI + 1;
                        lock3.notifyAll();
                    }
                }
            });
        }
        for (int i = 0; i < 10; i++) {
            threads3[i].start();
        }
        Thread.sleep(200);
    }
}
