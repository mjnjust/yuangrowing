package com.mj.yuangrowing.jdk.concurrent.aclh;

/**
 * @Description
 * @Author maojun
 * @Date 2022/3/3
 */
public abstract class AbstractDequeue {
    protected Node head;
    protected Node tail;

    public abstract void put(Node node);

    public abstract Node pull();

    public synchronized void print() {
        if (head == null) {
            System.out.println("empty queue");
        } else {
            Node temp = head;
            System.out.println();
            while (temp != null) {
                System.out.print("->" + temp.getVal());
                temp = temp.getNext();
            }
            System.out.println();
        }
    }
}
