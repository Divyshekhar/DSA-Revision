package linked_list;

public class Node {

    public int value;
    public Node next;

    public Node() {

    }

    public Node(int val) {
        this.value = val;
        this.next = null;
    }

    public Node(int val, Node next) {
        this.value = val;
        this.next = next;
    }
}
