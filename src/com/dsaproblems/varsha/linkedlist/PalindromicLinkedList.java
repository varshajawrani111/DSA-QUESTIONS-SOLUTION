package com.dsaproblems.varsha.linkedlist;

public class PalindromicLinkedList {

    public static boolean isPalindrome(Node head) {

        if(head == null || head.next == null)
            return true;

        Node fast = head;
        Node slow = head;

        //finding the middle of the linked list
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reversing the list from middle to end
        Node secondHalf = ReverseALinkedList.ReverseALinkedListIterative(slow); //reverse logic for second half of the list
        Node firstHAlf = head;

        //Looping to find if palindromic or not
        while (secondHalf != null) {

            if(firstHAlf.data != secondHalf.data)
                return false;

            firstHAlf = firstHAlf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);

        if(isPalindrome(head)){
            System.out.println("List is a palindrome");
        }
        else{
            System.out.println("List is not a palindrome");
        }
    }
}
