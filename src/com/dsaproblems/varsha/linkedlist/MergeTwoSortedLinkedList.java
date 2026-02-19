package com.dsaproblems.varsha.linkedlist;

public class MergeTwoSortedLinkedList {

    public static Node MergeSortedLinkedList(Node head1, Node head2) {

        if (head1 == null && head2 == null) {
            return null;
        }

        Node dummyHead = new Node(-1); //to maintain the reference of the head
        Node curr = dummyHead; //to move the curr node to create the list

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                curr.next = head1;
                head1 = head1.next;
            }else {
                curr.next = head2;
                head2 = head2.next;
            }

            curr = curr.next;
        }

        if (head1 != null) {
            curr.next = head1;
        }
        if (head2 != null) {
            curr.next = head2;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        ReverseALinkedList.printList(head1);

        Node head2 = new Node(1);
        head2.next = new Node(12);
        head2.next.next = new Node(13);
        head2.next.next.next = new Node(14);
        head2.next.next.next.next = new Node(15);
        head2.next.next.next.next.next = new Node(16);

        ReverseALinkedList.printList(head2);

        Node head = MergeSortedLinkedList(head1,head2);

        ReverseALinkedList.printList(head);
    }
}
