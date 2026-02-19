package com.dsaproblems.varsha.binarySearchTree;

public class ConvertSortedListIntoBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    static class  Node{
        int val;
        Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }

    static Node head;

    //this is using slow and fast pointers-->TC: O(nlogn)
    public static TreeNode buildBST(Node head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) { //if one node in tree than that should be the root of the tree
            return new TreeNode(head.val);
        }

        Node slow = head;
        Node fast = head.next;
        Node prev = null;

        //to get the middle element in linked list
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is middle
        TreeNode root = new TreeNode(slow.val);

        // split left list
        if (prev != null) {
            prev.next = null;
        }

        Node rightHalf = slow.next;

        root.left = buildBST(head);
        root.right = buildBST(rightHalf);

        return root;
    }

    public static TreeNode buildBalanceBSTFromList(Node node) {


        int count = countNodes(head); //counting the number of nodes i list
        head = node;
        return constructBST(head, 0, count-1);

    }

    public static TreeNode constructBST(Node head, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start)/2; //this will traverse linked list only once

        //construct left subtree
        TreeNode left = constructBST(head, start, mid -1);

        //construct root
        TreeNode root = new TreeNode(head.val);
        head = head.next;

        //construct right subtree
        TreeNode right = constructBST(head, mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }

    public static int countNodes(Node node) {
        if (node == null) {
            return 0;
        }

        int count = 0;

        while (node != null){
            node = node.next;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        TreeNode root = buildBST(head);
        System.out.println(root.val);

        TreeNode root1 = buildBalanceBSTFromList(head);
        System.out.println(root.val);
    }
}
