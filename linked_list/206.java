
import linked_list.Node;

class linked_list {

    public Node reverseList(Node head) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}
