package com.dsaproblems.varsha.linkedlist;

public class AddTwoNumberIninkedList {

    public static Node addTwoNumbers(Node head1, Node head2) {

        if (head1 == null && head2 == null) {
            return null;
        }

        Node dummyHead = new Node(0);
        Node tail = dummyHead;
        int carry = 0;

        while (head1 != null || head2 != null || carry != 0) {

            int sum = carry;

            if(head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }

            if(head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }

            carry = sum / 10; //this will return the carry node
            tail.next = new Node(sum % 10); //this will add the units digit as a node
            tail = tail.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        Node list1 = new Node(2);
        list1.next = new Node(4);
        list1.next.next = new Node(3);

        Node list2 = new Node(5);
        list2.next = new Node(6);
        list2.next.next = new Node(4);

        Node list3 = addTwoNumbers(list1,list2);

        ReverseALinkedList.printList(list3);
    }
}
