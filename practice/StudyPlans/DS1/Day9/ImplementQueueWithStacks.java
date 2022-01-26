package StudyPlans.DS1.Day9;

import java.util.Stack;

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> revS1;
    int front;

    public MyQueue() {
        s1 = new Stack<>();
        revS1 = new Stack<>();
    }
    
    public void push(int x) {
        if(s1.isEmpty()) front = x;
        while(!s1.isEmpty()){
            revS1.push(s1.pop());
        }
        revS1.push(x);
        while(!revS1.isEmpty()) s1.push(revS1.pop());
    }
    
    public int pop() {
        int temp = s1.pop();
        if(!s1.isEmpty()) front = s1.peek();
        return temp;
    }
    
    public int peek() {
        return front;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

public class ImplementQueueWithStacks {


    
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
    }
}
