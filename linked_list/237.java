
import linked_list.Node;

class linked_list {

    public void deleteNode(Node node) {
        Node temp = node;
        temp.value = temp.next.value;
        temp.next = temp.next.next;
    }

    public static void main(String[] args) {

    }
}
