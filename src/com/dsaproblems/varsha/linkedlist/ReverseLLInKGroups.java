package com.dsaproblems.varsha.linkedlist;

public class ReverseLLInKGroups {

    public static Node getKthNode(Node temp, int k) {

         k -= 1;
         while (temp != null && k > 0) {
             k--;
             temp = temp.next;
         }

         return temp;
    }

    public static Node reverseALinkedList(Node head){

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

    public static Node reverseKGroup(Node head, int k) {

        Node temp = head;
        Node prev = null;

        while (temp != null) {

            Node kthNode = getKthNode(temp, k);

            //if the k group does not exist
            if(kthNode == null){
                if(prev != null){
                    prev.next = temp;
                }
                break;
            }

            //storing the nextnode of k group
            Node nextNode = kthNode.next;
            kthNode.next = null; //separating the k size linked list for reversal

            //reversing the kth size linked list which will return the head which will be the kth node
            kthNode = reverseALinkedList(temp);

            //if it is the first node we need to update the head
            if(temp == head){
                head = kthNode;
            }
            else {
                prev.next = kthNode;
            }

            prev = temp;
            temp = nextNode;
        }

        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        ReverseALinkedList.printList(head);

        head = reverseKGroup(head, 2);

        ReverseALinkedList.printList(head);

    }

}
