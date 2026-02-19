package com.dsaproblems.varsha.linkedlist;

public class CloneLinkedListWithRandomPointers {

    // Node definition
    static class Node {
        int data;
        Node next;
        Node random;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

    //Clone function
    public static Node clonedLinkedList(Node head) {

        if (head == null) {
            return null;
        }

        //1. Interweave the copied node
        Node curr = head;
        while (curr != null) {

            //new node
            Node copy = new Node(curr.data);
            copy.next = curr.next; //this will connect copy node to original next node
            curr.next = copy; //original node will be connected to its copy
            curr = curr.next.next; //curr will be pointed to next original node
        }

        //2. Connect the random pointer
        curr = head;
        while (curr != null) {

            if(curr.random != null) {
                curr.next.random = curr.random.next; //curr.next.random ==> copy node random
            }

            curr = curr.next.next;
        }

        //3.Separate both the list
        curr = head;
        Node copyHead = curr.next;

        while (curr != null) {

            Node copy = curr.next; //copy will point to current next node which is its copy node
            curr.next = copy.next; //current will point to original next node

            if(copy.next != null) {
                copy.next = copy.next.next; //copy will point to copy next node
            }

            curr = curr.next;
        }

        return copyHead;
    }

    // Print list (data + random)
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            int randomVal = (temp.random != null) ? temp.random.data : -1;
            System.out.print("[" + temp.data + ", random->" + randomVal + "] ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create original list
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);

        a.next = b;
        b.next = c;

        a.random = c;
        b.random = a;
        c.random = b;

        System.out.println("Original List:");
        printList(a);

        Node cloned = clonedLinkedList(a);

        System.out.println("Cloned List:");
        printList(cloned);
    }
}
