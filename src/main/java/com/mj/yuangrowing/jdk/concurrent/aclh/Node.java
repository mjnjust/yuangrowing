package com.mj.yuangrowing.jdk.concurrent.aclh;

/**
 * @Description
 * @Author maojun
 * @Date 2022/3/3
 */
class Node<T> {
    private T val;
    private Node next;
    private Node prev;

    public Node(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
