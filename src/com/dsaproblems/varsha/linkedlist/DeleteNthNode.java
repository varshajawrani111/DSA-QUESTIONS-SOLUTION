package com.dsaproblems.varsha.linkedlist;

import java.util.Scanner;

public class DeleteNthNode {

    public static void deleteNthNode(Node head, int n) {

        if (head == null) {
            return;
        }

        Node dummyHead = new Node(-1);
        dummyHead.next = head;

        Node slow = dummyHead;
        Node fast = dummyHead;

        for(int i = 0; i<= n; i++){
            fast = fast.next; //moving the fast pointer till n+1
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next; //deleting the slow.next node

        head = dummyHead.next;
    }

    public static void main(String[] args) {

        System.out.println("Enter the value of n: ");
        int n = new Scanner(System.in).nextInt();

        LinkedList.addFirst(1);
        LinkedList.addLast(2);
        LinkedList.addLast(3);
        LinkedList.addLast(4);
        LinkedList.addLast(5);
        LinkedList.addLast(6);

        System.out.println("Before Deletion");
        LinkedList.printList();

        deleteNthNode(LinkedList.head, n);

        System.out.println("After Deletion");
        LinkedList.printList();

    }

}
