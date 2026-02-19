package com.dsaproblems.varsha.linkedlist;

public class IntersectionOfTwoLinkedList {

    public static Node getIntersectingNode(Node headA, Node headB) {

        if(headA == null || headB == null){
            return null;
        }

        Node ptrA = headA;
        Node ptrB = headB;

        while (ptrA != ptrB){

            //Assigning pointer A to headA or next node depending on the condition
            ptrA = (ptrA == null) ? headB : ptrA.next;
            //Assigning pointer B to headB or next node depending on the condition
            ptrB = (ptrB == null) ? headA : ptrB.next;
        }

        return ptrA;
    }

    public static void main(String[] args) {

        Node common = new Node(1);
        common.next = new Node(5);
        common.next.next = new Node(4);
        common.next.next.next = new Node(5);

        Node head1 = new Node(4);
        head1.next = common;

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = common;

        Node intersection = getIntersectingNode(head1, head2);

        if(intersection != null)
            System.out.println("Intersection node: " + intersection.data);
        else
            System.out.println("No Intersection node");

    }
}
