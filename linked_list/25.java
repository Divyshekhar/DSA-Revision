
import linked_list.Node;
/*

    Explaination needed in logic of how this works

*/

class linked_list {

    public Node getKthNode(Node node, int k) {
        k = k - 1;
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }

    public Node reverse(Node node) {
        Node temp = node;
        Node prev = null;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return temp;
    }

    public Node reverseKGroup(Node head, int k) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            Node kth = getKthNode(temp, k);
            if (kth == null) {
                if (prev != null) {
                    prev.next = temp;
                    break;
                }
            }
            Node kthNext = kth.next;
            kth.next = null;
            reverse(temp);
            if (temp == head) {
                head = kth;
            } else {
                prev.next = kth;
            }
            prev = temp;
            temp = kthNext;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
