package com.dsaproblems.varsha.linkedlist;


public class MiddleOfLinkedList {

    public static Node findMiddleOfList(Node head) {

        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        LinkedList.addFirst(1);
        LinkedList.addLast(2);
        LinkedList.addLast(3);
        LinkedList.addLast(4);
        LinkedList.addLast(5);

        LinkedList.printList();

        Node middle = findMiddleOfList(LinkedList.head);

        if(middle!=null){
            System.out.println(middle.data);
        }

    }
}
