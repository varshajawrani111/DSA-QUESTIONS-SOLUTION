package com.dsaproblems.varsha.linkedlist;

import java.util.Scanner;

public class RotateALinkedList {

    public static void rotate(int k){

        //Base case
        if(LinkedList.head==null || LinkedList.head.next==null || k==0){
            return;
        }

        Node tail = LinkedList.head;
        int length = 1;

        //traversing the linked list to find the tail and length of the list
        while(tail.next!=null){
            tail = tail.next;
            length ++;
        }

        //Making the list circular
        tail.next = LinkedList.head;

        //finding node number of the new tail
        k = k % length;
        if(k == 0)
            return;

        int stepsToBeTraversed = length - k;

        Node newTail = LinkedList.head;

        for(int i=1; i<stepsToBeTraversed; i++){
            newTail = newTail.next;
        }

        //Breaking the circle and forming the rotated linked list
        LinkedList.head = newTail.next;
        newTail.next = null;
    }


    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        System.out.println("Enter the value of K:");
        int k = new Scanner(System.in).nextInt();

        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println("Before Rotating List:");
        list.printList();

        rotate(k);

        System.out.println("After Rotating List:");
        list.printList();

    }
}
