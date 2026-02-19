package com.dsaproblems.varsha.linkedlist;

public class LengthOfTheLoop {

    public static int findLengthOfTheLoop(Node head) {

        Node slow = head;
        Node fast = head;

        //TO detect the cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            //Cycle detection
            if (slow == fast){

                //counter
                int count = 1;
                Node temp = slow.next;

                while (temp != slow){
                    count++;
                    temp = temp.next;
                }
                return count;
            }
        }

        return 0;

    }

    public static void main(String[] args) {

        FloydCycleDetection.LinkedList list = new FloydCycleDetection.LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        FloydCycleDetection.LinkedList.createCycle(2);

        System.out.println(findLengthOfTheLoop(FloydCycleDetection.LinkedList.head));
    }
}
