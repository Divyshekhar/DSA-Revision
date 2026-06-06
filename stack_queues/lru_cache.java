import java.util.*;
class stack_queues {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
 @SuppressWarnings("unused")
    class LRUCache{
        Node head;
        Node tail;
        int cap;
        Map<Integer, Node> map;

        public LRUCache(int cap) {
            this.cap = cap;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            map = new HashMap<>();
            head.next = tail;
            tail.prev = head;
        }

        public void deleteNode(Node node){
            Node delNext = node.next;
            Node delPrev = node.prev;
            delNext.prev = delPrev;
            delPrev.next = delNext;
        }

        public void insertAtHead(Node node){
            Node temp = head.next;
            node.next = temp;
            node.prev = head;
            temp.prev = node;
            head.next = node;
        }

        public int get(int key){
            if(map.containsKey(key)){
                Node node = map.get(key);
                deleteNode(node);
                insertAtHead(node);
                return node.val;
            }else{
                return -1;
            }
        }

        public void put(int key, int value){
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.val = value;
                deleteNode(node);
                insertAtHead(node);
            }else{
                if(map.size() == cap){
                    Node delNode = tail.prev;
                    deleteNode(delNode);
                    map.remove(delNode.key);
                }
                Node node = new Node(key, value);
                insertAtHead(node);
                map.put(key, node);
            }
        }
    }
    public static void main(String[] args) {

    }
}
