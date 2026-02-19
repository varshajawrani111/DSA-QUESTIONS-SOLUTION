package com.dsaproblems.varsha.linkedlist;

public class FloydCycleDetection {


    static class LinkedList {
        static Node head;

        // Insert at end
        public void insert(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                return;
            }

            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        // Create cycle (for testing)
        public static void createCycle(int pos) {
            if (pos == -1) return;

            Node temp = head;
            Node cycleNode = null;
            int index = 0;

            while (temp.next != null) {
                if (index == pos) {
                    cycleNode = temp;
                }
                temp = temp.next;
                index++;
            }
            temp.next = cycleNode;
        }

        // Floyd's Cycle Detection
        public boolean hasCycle() {
            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    return true; // cycle detected
                }
            }
            return false; // no cycle
        }
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        LinkedList.createCycle(2); // creates cycle at node 30

        System.out.println("Cycle present? " + list.hasCycle());
    }
}

