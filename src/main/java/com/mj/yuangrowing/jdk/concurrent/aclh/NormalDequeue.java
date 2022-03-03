package com.mj.yuangrowing.jdk.concurrent.aclh;

/**
 * @Description
 * @Author maojun
 * @Date 2022/3/3
 */
public class NormalDequeue extends AbstractDequeue {
    @Override
    public Node pull() {
        if (head == null) {
            return null;
        } else if (head == tail) {
            Node result = head;
            head = null;
            tail = null;
            return result;
        } else {
            Node result = head;
            head = head.getNext();
            head.setPrev(null);
            return result;
        }
    }

    @Override
    public void put(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }
}
