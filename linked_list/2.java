
import linked_list.Node;

class linked_list {

    public Node addTwoNumber(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.value : 0;
            int y = (l2 != null) ? l2.value : 0;
            int sum = x + y + carry;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
