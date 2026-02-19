package com.dsaproblems.varsha.linkedlist;

public class LinkedList {
    static Node head;

    //Insert at first location
    public static void addFirst(int value){

        Node newNode = new Node(value);

        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    //Insert at end
    public static void addLast(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            return;
        }

        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    //Delete first element of LinkedList
    public static void deleteFirst(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    //Delete last element of LinkedList
    public static void deleteLast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        //list contains only one node
        if(head.next == null){
            head = null;
            return;
        }

        Node secondLast = head;
        Node last = head.next;

        while(last.next != null){

            secondLast = secondLast.next;
            last = last.next;
        }

        secondLast.next = null;
    }

    //To print linkedlist
    public static void printList(){

        if(head == null){
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {

        addFirst(1);
        addLast(2);
        addLast(3);

        printList();

        deleteFirst();
        printList();

        deleteLast();
        printList();

    }
}
