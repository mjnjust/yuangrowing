package mj.yuangrowing.jdk.concurrent.aclh;

import java.util.concurrent.CountDownLatch;

public class NomalQueue {
    private Node head;
    private Node tail;

    public static void main(String[] args) throws Exception {
        NomalQueue nomalQueue = new NomalQueue();
        int nodeNums = 15;
        CountDownLatch countDownLatch = new CountDownLatch(nodeNums);
        for (int x = 0; x < nodeNums; x++) {
            final int fx = x;
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                nomalQueue.add(new Node(fx));
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        nomalQueue.print();
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
        if (head == null) {
            // 没有元素
            head = node;
            tail = node;
        } else {
            // 有元素时 只需要挪动tail
            tail.setNext(node);
            tail = node;
        }
    }

    public synchronized void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getVal());
            temp = temp.getNext();
        }
    }
}
