package com.dsaproblems.varsha.linkedlist;

import java.util.Scanner;

public class FindStartingPointOfTheLoop {

    public static Node findStartingPointOfTheLoop(Node head) {

        Node slow = head;
        Node fast = head;

        //TO detect the cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        //No cycle
        // No cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }

    public static void main(String[] args) {

        FloydCycleDetection.LinkedList list = new FloydCycleDetection.LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        FloydCycleDetection.LinkedList.createCycle(2);

        Node start = findStartingPointOfTheLoop(FloydCycleDetection.LinkedList.head);

        if(start == null)
            System.out.println(-1);
        else
            System.out.println(start.data);
    }
}
