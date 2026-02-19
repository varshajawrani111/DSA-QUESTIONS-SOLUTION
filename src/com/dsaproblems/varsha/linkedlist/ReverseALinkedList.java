package com.dsaproblems.varsha.linkedlist;

import java.util.List;

public class ReverseALinkedList {

    public static Node ReverseALinkedListIterative(Node head){

         Node prev = null;
         Node curr = head;

         while(curr!=null){

             Node next = curr.next; // store next
             curr.next = prev;      // reverse link
             prev = curr;           // move prev
             curr = next;           // move curr
         }
         head = prev;

        return head;
    }

    public static Node ReverseALinkedListRecursive(Node head){

        //Base case if list is empty or contains only one node
        if(head==null || head.next==null){
            return head;
        }

        //Reverse the rest of the list
        Node newHead = ReverseALinkedListRecursive(head.next);

        //fix current node
        head.next.next = head;

        //break the old link
        head.next = null;

        return newHead;
    }

    //To print linkedlist
    public static void printList(Node head){

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

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Reversing the linked list using iterative approach");
        head = ReverseALinkedListIterative(head);
        printList(head);

        System.out.println("Reversing the linked list using recursive approach");
        head = ReverseALinkedListRecursive(head);
        printList(head);
    }
}
