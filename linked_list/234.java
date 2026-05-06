
import linked_list.Node;

class linked_list {

    public Node reverse(Node node) {
        Node temp = node;
        Node prev = null;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public boolean isPalindrome(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node head2 = reverse(slow.next);
        Node temp = head;
        Node temp2 = head2;
        while (temp != null && temp2 != null) {
            if (temp.value != temp2.value) {
                reverse(head2);
                return false;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        reverse(head2);
        return true;

    }

    public static void main(String[] args) {

    }
}
