package com.mj.learn.jvm.slot;

public class SlotTest {
    public static void main(String[] args) {
        test3();
        System.out.println("-------------------");
    }

    /**
     * 回收不掉 因为gc时a还在test1的方法作用域里面
     */
    public static void test1() {
        byte[] a = new byte[64 * 1024 * 1024];
        System.gc();
    }

    /**
     * 回收不掉
     * 因为虽然a的作用域在花括号里面了,外面访问不到,但是其实局部变量表中的slot还并未释放，对这64M空间的
     * 引用其实还在
     */
    public static void test2() {
        {
            byte[] a = new byte[64 * 1024 * 1024];
        }
        System.gc();
    }

    /**
     * 回收掉了
     */
    public static void test3() {
        {
            byte[] a = new byte[64 * 1024 * 1024];
        }
        int bb = 0;
        System.gc();
    }
}
