package mj.yuangrowing.jdk.concurrent.aclh;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class CLHQueue {
    private volatile Node head;
    private volatile Node tail;

    private static final Unsafe unsafe = reflectGetUnsafe();
    private static long headOffset;
    private static long tailOffset;

    static {
        try {
            headOffset = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getDeclaredField("tail"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        CLHQueue clhQueue = new CLHQueue();
        int nodeNums = 15;
        CountDownLatch countDownLatch = new CountDownLatch(nodeNums);
        unsafe.compareAndSwapObject(clhQueue,CLHQueue.headOffset,null,new Node(10));
        clhQueue.add(new Node(1));
        clhQueue.add(new Node(2));
        clhQueue.add(new Node(3));
        for (int x = 0; x < nodeNums; x++) {
            final int fx = x;
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clhQueue.add(new Node(fx));
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        clhQueue.print();
    }

    public Node pull() {
        if (head == null) {
            // 没有元素
            return null;
        } else {
            if (head == tail) {
                // 头尾指向同一个元素时 只有一个元素
                head = null;
                tail = null;
                return head;
            } else {
                // 大于一个元素 只需要挪动head即可
                Node temp = head;
                head = head.getNext();
                return temp;
            }
        }
    }

    public void add(Node node) {
        for (; ; ) {
            Node temp = tail;
            if (temp == null) {
                // 没有元素
                if (unsafe.compareAndSwapObject(this, headOffset, null, node)) {
                    tail = node;
                    break;
                }
            } else {
                // 有元素时 只需要挪动tail
                node.setPrev(temp);
                if (unsafe.compareAndSwapObject(this, tailOffset, temp, node)) {
                    tail = node;
                    break;
                }
            }
        }
    }

    public synchronized void print() {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            index++;
            System.out.println(temp.getVal());
            temp = temp.getNext();
        }
        System.out.println("nums:" + index);
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
}
