package com.dsaproblems.varsha.linkedlist;

public class FlatteningOfLinkedList {

    public static class Node {
        int data;
        Node next;
        Node child;

        public Node(int val) {
            this.data = val;
            this.next = null;
            this.child = null;
        }
    }

    public static Node merge(Node list1, Node list2) {

        Node dummyHead = new Node(-1);
        Node curr = dummyHead;

        while (list1 != null && list2 != null) {

            if (list1.data < list2.data) {
                curr.child = list1;
                curr = list1; //this will move the curr node to newly attached node like we do in mergesort
                list1 = list1.child; //moving the list pointer ahead
            }
            else {
                curr.child = list2;
                curr = list2; //this will move the curr node to newly attached node like we do in mergesort
                list2 = list2.child; //moving the list pointer ahead
            }

            curr.next = null; //making sure next is always null
        }

        if(list1 != null) {
            curr.child = list1;
        }

        if(list2 != null) {
            curr.child = list2;
        }

        return dummyHead.child;
    }

    public static Node flattenLinkedList(Node head) {

        if(head == null || head.next == null) {
            return head;
        }

        Node mergeHead = flattenLinkedList(head.next);
        head = merge(mergeHead, head);

        return head;
    }

    // Print using bottom pointer
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.child;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node(5);
        head.child = new Node(7);
        head.child.child = new Node(8);
        head.child.child.child = new Node(30);

        head.next = new Node(10);
        head.next.child = new Node(20);

        head.next.next = new Node(19);
        head.next.next.child = new Node(22);
        head.next.next.child.child = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.child = new Node(35);
        head.next.next.next.child.child = new Node(40);
        head.next.next.next.child.child.child = new Node(45);

        Node flat = flattenLinkedList(head);
        printList(flat);
    }

}
