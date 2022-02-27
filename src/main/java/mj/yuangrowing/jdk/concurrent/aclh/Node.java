package mj.yuangrowing.jdk.concurrent.aclh;

class Node {
    private Node prev;
    private Node next;
    private int val;

    public Node(int val) {
        this.val = val;
    }

    Node getPrev() {
        return prev;
    }

    void setPrev(Node prev) {
        this.prev = prev;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
