
import linked_list.Node;

class linked_list {

    public Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        Node tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        tail.next = head;
        Node newTail = head;
        for (int i = 1; i < len - k; i++) {
            newTail = newTail.next;
        }
        head = newTail.next;
        newTail.next = null;
        return head;
    }

    public static void main(String[] args) {

    }

}
