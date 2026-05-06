
import java.util.*;

class StackUsingQueue{

    Queue<Integer> q = new ArrayDeque<>();
    
    public void push(int x){
        q.offer(x);
        int size = q.size();
        for(int i = 0; i<size-1; i++){
            q.offer(q.poll());
        }
    }
    public int top(){
        return q.peek();
    }
    public int pop(){
        return q.poll();
    }
    public boolean isEmpty(){
        return q.isEmpty();
    }


    public static void main(String[] args) {
        
    }
}