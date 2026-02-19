package com.dsaproblems.varsha.queue;

public class QueueUsingStack {

    //Stack class for implementing Queue
    static class StackOperations {

        int[] arr;
        int top;

        StackOperations(int size) {
            arr = new int[size];
            top = -1;
        }

        public void push(int val) {
            if (top == arr.length - 1) {
                throw new RuntimeException("Stack is full");
            }
            arr[++top] = val;
        }

        public int pop() {
            if (top == -1) {
                throw new RuntimeException("Stack is empty");
            }
            return arr[top--];
        }

        public int peek() {
            if (top == -1) {
                throw new RuntimeException("Stack is empty");
            }
            return arr[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    private final StackOperations stack1;
    private final StackOperations stack2;

    QueueUsingStack(int capacity) {
        stack1 = new StackOperations(capacity);
        stack2 = new StackOperations(capacity);
    }

    //Enqueue
    public void enqueue(int val) {
        stack1.push(val);
    }

    //Dequeue
    public int dequeue() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        //if stack is empty the only transfer elements from stack1 to stack 2
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    //Peek operation
    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        //if stack is empty the only transfer elements from stack1 to stack 2
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    //IsEmpty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack(10);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.dequeue()); // 10
        System.out.println(q.dequeue()); // 20

        q.enqueue(40);

        System.out.println(q.dequeue()); // 30
        System.out.println(q.peek());    // 40
    }



}
