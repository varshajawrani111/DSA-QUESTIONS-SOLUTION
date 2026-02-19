package com.dsaproblems.varsha.queue;

public class QueueOperations {

    //this is the linear array implementation not the circular array implementation
    int[] queue;
    int front = 0;
    int rear = -1;
    int capacity;

    QueueOperations(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];
    }

    public void enqueue(int data){
        if(isFull()){
            throw  new RuntimeException("Queue is full");
        }

        queue[++rear] = data;
        System.out.println(data + " enqueued in queue");

    }

    public void dequeue(){

        if(isEmpty()){
            throw  new RuntimeException("Queue is empty");
        }

        System.out.println(queue[front++] + " dequeued from queue");

    }

    public int peek(){

        if(isEmpty()){
            throw  new RuntimeException("Queue is empty");
        }

        return queue[front];
    }

    public boolean isEmpty(){
        return front > rear;
    }

    public boolean isFull(){
        return rear == capacity-1;
    }

    public static void main(String[] args) {

        QueueOperations queue = new QueueOperations(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.dequeue();
        queue.dequeue();

        System.out.println(queue.peek()+ " is front element from queue");

    }
}
