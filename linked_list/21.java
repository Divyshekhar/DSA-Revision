
import linked_list.Node;

class linked_list {

    public Node mergeTwoLists(Node list1, Node list2) {
        Node temp1 = list1;
        Node temp2 = list2;
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (temp1 != null && temp2 != null) {
            if (temp1.value > temp2.value) {
                temp.next = temp2;
                temp = temp2;
                temp2 = temp2.next;
            } else {
                temp.next = temp1;
                temp = temp1;
                temp1 = temp1.next;
            }
        }
        while (temp1 != null) {
            temp.next = temp1;
            temp = temp1;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            temp.next = temp2;
            temp = temp2;
            temp2 = temp2.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
