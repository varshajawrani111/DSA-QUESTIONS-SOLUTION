package com.dsaproblems.varsha.linkedlist;

public class OddEvenLinkedList {

    public static void oddEvenLinkedList(Node head) {

        if(head==null || head.next==null){
            return;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while(even != null && even.next != null){

            odd.next = even.next;  //connecting the odd node index together
            odd = odd.next; //moving the odd pointer forward

            even.next = odd.next; //connecting the even node index together
            even = even.next; //moving the even pointer forward
        }

        odd.next = evenHead;

    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.printList();

        oddEvenLinkedList(list.head);
        list.printList();
    }
}
