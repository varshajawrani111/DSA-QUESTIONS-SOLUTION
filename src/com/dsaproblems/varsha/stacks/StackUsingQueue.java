package com.dsaproblems.varsha.stacks;

public class StackUsingQueue {

    //Node class for the queue implementation
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    //Queue implementation using linkedlist
    static class Queue{

        private Node front;
        private Node rear;
        private int size;

        Queue(){
            front = null;
            rear = null;
            size = 0;
        }

        public void enqueue(int data){
            Node newNode = new Node(data);

            if(front == null){
                front = rear = newNode;
            }

            rear.next = newNode;
            rear = newNode;
            size++;
        }

        public int dequeue(){

            if(front == null){
                throw new RuntimeException("Queue is empty");
            }

            int data = front.data;
            front = front.next;

            //if queue becomes empty
            if(front == null){
                rear = null;
            }
            size--;

            return data;
        }

        public int peek(){
            if(front == null){
                throw new RuntimeException("Queue is empty");
            }
            return front.data;
        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            return size == 0;
        }
    }

    //Stack implementation using queue
    private final Queue queue;

    StackUsingQueue(){
        queue = new Queue();
    }

    //push operation of stack
    public void push(int data){
        queue.enqueue(data);

        int size = queue.size();

        for(int i = 0; i < size; i++){
            queue.enqueue(queue.dequeue()); //first removing the data from queue and then adding in reverse manner
        }
    }

    //pop operation of stack
    public int pop(){

        if(queue.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }

        return queue.dequeue();
    }

    //peek operation of stack
    public int peek(){
        if(queue.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }

        return queue.peek();
    }

    public static void main(String[] args) {

        StackUsingQueue stack = new StackUsingQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.peek());
        System.out.println(stack.pop());


        System.out.println(stack.peek());
        System.out.println(stack.pop());

    }
}
