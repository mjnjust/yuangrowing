package com.mj.yuangrowing.jdk.concurrent.aclh;

/**
 * @Description
 * @Author maojun
 * @Date 2022/3/3
 */
public abstract class AbstractDequeue<T> {
    private Node<T> head;
    private Node<T> tail;

    public abstract void put(Node<T> node);

    public abstract Node<T> pull();

    protected Node<T> getHead() {
        return this.head;
    }

    protected Node<T> getTail() {
        return this.tail;
    }

    protected void setHead(Node<T> node) {
        this.head = node;
    }

    protected void setTail(Node<T> node) {
        this.tail = node;
    }

    public synchronized void print() {
        if (getHead() == null) {
            System.out.println("empty queue");
        } else {
            Node<T> temp = getHead();
            System.out.println();
            while (temp != null) {
                System.out.print("->" + temp.getVal());
                temp = temp.getNext();
            }
            System.out.println();
        }
    }
}
