package com.dsaproblems.varsha.linkedlist;

public class MergeSortOnLinkedList {

    public static Node mergeSort(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        //this part is the splitting of nodes like we do in arrays
        Node midNode = getMiddleNode(head); //getting hte middle node
        Node rightHalf = midNode.next; //allocating the righthalf from middle node next
        midNode.next = null; //forming left by connecting middle next to null

        //Recursively calling merge sort for the left half and right half
        Node left = mergeSort(head);
        Node right = mergeSort(rightHalf);

        return merge(left, right);

    }

    public static Node merge(Node left, Node right){

        if (left == null && right == null){
            return null;
        }

        Node dummy = new Node(-1);
        Node curr = dummy;

        while (left != null && right != null){
            if (left.data < right.data){
                curr.next = left;
                left = left.next;
            }
            else{
                curr.next = right;
                right = right.next;
            }

            curr = curr.next;
        }

        if(left != null){
            curr.next = left;
        }
        if(right != null){
            curr.next = right;
        }

        return  dummy.next;
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

        mergeSort(head);

        ReverseALinkedList.printList(head);
    }
}
