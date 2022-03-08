package com.mj.yuangrowing.jdk.concurrent.aclh;

/**
 * @Description
 * @Author maojun
 * @Date 2022/3/3
 */
public class NormalDequeue<T> extends AbstractDequeue<T> {
    @Override
    public Node<T> pull() {
        if (getHead() == null) {
            return null;
        } else if (getHead() == getTail()) {
            Node result = getHead();
            setHead(null);
            setTail(null);
            return result;
        } else {
            Node result = getHead();
            setHead(getHead().getNext());
            getHead().setPrev(null);
            return result;
        }
    }

    @Override
    public void put(Node<T> node) {
        if (getHead() == null) {
            setHead(node);
            setTail(node);
        } else {
            getTail().setNext(node);
            setTail(node);
        }
    }
}
