package com.dsaproblems.varsha.linkedlist;

public class ReorderTheLinkedList {

    public static void reorder(Node head) {

        if (head == null || head.next == null) {
            return;
        }

        Node midNode = getMiddleNode(head);
        Node reversedRightHalf = ReverseALinkedList.ReverseALinkedListIterative(midNode.next); //this will return the right half in reversed manner
        midNode.next = null; //this will give the left half

        Node leftHalf = head; //creating the leftHalf list

        while(reversedRightHalf != null) {

            //this is for preserving the original links
            Node temp1 = leftHalf.next;
            Node temp2 = reversedRightHalf.next;

            //alternatively adding the links from left and right
            leftHalf.next = reversedRightHalf;
            reversedRightHalf.next = temp1;

            //moving the left and right pointers ahead
            leftHalf = temp1;
            reversedRightHalf = temp2;
        }
    }

    private static Node getMiddleNode(Node head) {
        Node slow = head;
        Node fast = head.next; //important if we initialize both with head it will give StackOverFlow error

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(12);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(31);

        ReverseALinkedList.printList(head);

        reorder(head);

        ReverseALinkedList.printList(head);
    }
}
