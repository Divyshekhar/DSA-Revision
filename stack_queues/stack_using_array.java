
class StackUsingArray {

    int[] arr;
    int top;
    int capacity;

    public StackUsingArray(int size) {
        this.capacity = size;
        this.arr = new int[capacity];
        this.top = -1;
    }

    public void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflowed");
            return;
        }
        arr[++top] = x;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflowed");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("The stack is empty");
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return capacity - 1;
    }

    public static void main(String[] args) {

    }
}
