package com.dsaproblems.varsha.binarySearchTree;

public class RangeSumOfBST {

    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static int rangeSum(Node root, int low, int high){
        if(root==null){
            return 0;
        }

        //if root value is less than low than entire left subtree is invalid then search in right subtree
        if(root.val < low){
            return rangeSum(root.right, low, high);
        }

        //if root value is greater than high than entire right subtree is invalid search in left subtree
        if(root.val > high){
            return rangeSum(root.left, low, high);
        }

        return root.val +
                rangeSum(root.left, low, high) +
                rangeSum(root.right, low, high);
    }

    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);

        int low = 3;
        int high = 7;
        System.out.println(rangeSum(root,low,high));

    }
}
