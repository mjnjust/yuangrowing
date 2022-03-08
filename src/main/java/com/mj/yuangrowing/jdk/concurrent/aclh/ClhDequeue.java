package com.mj.yuangrowing.jdk.concurrent.aclh;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * @Description
 * @Author maojun
 * @Date 2022/3/3
 */
public class ClhDequeue<T> extends AbstractDequeue<T> {
    private static final VarHandle head_handler;
    private static final VarHandle tail_handler;

    protected Node<T> head;
    protected Node<T> tail;

    static {
        MethodHandles.Lookup l = MethodHandles.lookup();
        try {
            head_handler = l.findVarHandle(ClhDequeue.class, "head", Node.class);
            tail_handler = l.findVarHandle(ClhDequeue.class, "tail", Node.class);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    @Override
    protected Node<T> getHead() {
        return this.head;
    }

    @Override
    protected Node<T> getTail() {
        return this.tail;
    }

    @Override
    public void put(Node<T> node) {
        for (; ; ) {
            if (head == null) {
                if (tail_handler.compareAndSet(this, null, node)) {
                    head = tail;
                    break;
                }
            } else {
                Node temp = tail;
                if (tail_handler.compareAndSet(this, tail, node)) {
                    temp.setNext(tail);
                    break;
                }
            }
        }
    }

    @Override
    public Node<T> pull() {
        return null;
    }
}
