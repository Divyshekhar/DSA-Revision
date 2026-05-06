class QueueUsingArray{
    int[] arr;
    int capacity;
    int rear;
    int front;
    int size;
    
    public QueueUsingArray(int size){
        this.capacity = size;
        this.arr = new int[capacity];
        this.rear = 0;
        this.front = -1;
        this.size = 0;
    }

    public void enqueue(int x){
        if(size == capacity){
            System.out.println("Queue is overflowed");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }
    public int dequeue(){
        if(size == 0){
            System.out.println("Queue underflowed");
            return -1;
        }
        int val = arr[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }
    public int peek(){
        if(size == 0){
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == capacity;
    }

    public static void main(String[] args) {
        
    }
}