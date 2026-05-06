
import java.util.*;

class Node {

    int key;
    int value;
    Node next;
    Node prev;

    Node(int _key, int _value) {
        this.key = _key;
        this.value = _value;
        this.next = null;
        this.prev = null;
    }
}

@SuppressWarnings("unused")
class lru_cache {

    public Node head;
    public Node tail;
    public int cap;
    public Map<Integer, Node> mpp;

    public lru_cache(int capacity) {
        this.cap = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        mpp = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public void deleteNode(Node node) {
        Node delNext = node.next;
        Node delPrev = node.prev;
        delNext.prev = delPrev;
        delPrev.next = delNext;
    }

    public void insertAfterHead(Node node) {
        Node temp = head.next;
        head.next = node;
        node.next = temp;
        node.prev = head;
        temp.prev = node;
    }

    public int get(int key) {
        if (!mpp.containsKey(key)) {
            return -1;
        }
        Node node = mpp.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
    }

    public void put(int key, int val) {
        if (mpp.containsKey(key)) {
            Node node = mpp.get(key);
            node.value = val;
            deleteNode(node);
            insertAfterHead(node);
        } else {
            if (mpp.size() == cap) {
                Node delNode = tail.prev;
                deleteNode(delNode);
                mpp.remove(delNode.key);
            }
            Node node = new Node(key, val);
            insertAfterHead(node);
            mpp.put(node.key, node);
        }
    }

    public static void main(String[] args) {

    }
}
