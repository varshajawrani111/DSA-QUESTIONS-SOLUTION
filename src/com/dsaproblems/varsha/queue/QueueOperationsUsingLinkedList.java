package com.dsaproblems.varsha.queue;

public class QueueOperationsUsingLinkedList {

    static class  Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

        Node head;
        Node tail;

        public void enqueue(int data){
            Node newNode = new Node(data);

            if(head == null){
                head = tail = newNode; //for the first time the head and tail will be the same node
            }

            tail.next = newNode;
            tail = newNode;

            System.out.println(tail.data + " enqueued in queue");
        }

        public void dequeue(){
            if(head == null){
                throw  new RuntimeException("Queue is empty");
            }

            System.out.println(head.data+" dequeued from queue");
            head = head.next;

            if(head == null){
                tail = null;
            }
        }

        public int peek(){
            if(head == null){
                throw  new RuntimeException("Queue is empty");
            }

            return head.data;
        }


        public static void main(String[] args) {

            QueueOperationsUsingLinkedList queue = new QueueOperationsUsingLinkedList();

            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);

            queue.dequeue();
            queue.dequeue();

            System.out.println(queue.peek()+ " is the front element of queue");

        }
}
