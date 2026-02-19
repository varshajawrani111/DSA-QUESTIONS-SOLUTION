package com.dsaproblems.varsha.stacks;

public class StackOperationsUsingLinkedList {

    static class  Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head;

    public void push(int data){

        Node newNode = new Node(data);
        newNode.next = head; //the newNode will always be at the start that means stack top is always the head in linkedlist
        head = newNode;

        System.out.println("Pushed "+data);
    }

    public void pop(){
        if(head == null){
            throw  new RuntimeException("Stack is empty");
        }

        System.out.println("Popping "+head.data);
        head = head.next;
    }

    public int peek(){
        if(head == null){
            throw  new RuntimeException("Stack is empty");
        }

        return head.data;
    }

    public static void main(String[] args) {

        //performing stack operations
        //Mo need to mention the size as using linked list we can form dynamic size array
        StackOperationsUsingLinkedList stack = new StackOperationsUsingLinkedList();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();
        stack.pop();

        System.out.println(stack.peek()+" is the top element");


    }
}
