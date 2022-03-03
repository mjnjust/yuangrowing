package com.mj.yuangrowing.jdk.concurrent.aclh;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * @Description
 * @Author maojun
 * @Date 2022/3/3
 */
public class ClhDequeue extends AbstractDequeue {
    private static final VarHandle head_handler;
    private static final VarHandle tail_handler;

    static {
        MethodHandles.Lookup l = MethodHandles.lookup();
        try {
            head_handler = l.findVarHandle(ClhDequeue.class, "head", String.class);
            tail_handler = l.findVarHandle(ClhDequeue.class, "tail", String.class);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }


    @Override
    public void put(Node node) {
        if (head == null) {
            if (head_handler.compareAndSet(null, node)) {
                tail = head;
            }
        } else if (head == tail) {

        }
    }

    @Override
    public Node pull() {
        return null;
    }
}
