package com.dsaproblems.varsha.binaryTrees;

public class MaximumPathSumInBinaryTree {

    static class  Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int maxSum;

    public static int maxSum(Node root){
        maxSum = Integer.MIN_VALUE;

        maxPathSum(root);
        return maxSum;
    }

    public static int maxPathSum(Node root){
        if(root == null){
            return 0;
        }

        int leftSum = Math.max(0, maxPathSum(root.left));
        //0 because it will ignore the negative sum because it will never give maxSum
        int rightSum = Math.max(0, maxPathSum(root.right));

                          // path passing through current node
        maxSum = Math.max(root.data + leftSum + rightSum , maxSum);

        return root.data + Math.max(leftSum, rightSum); //this will tell us which path to take
    }

    public static void main(String[] args) {

        /*
                -10
                /  \
               9    20
                   / \
                  15  7
        */

        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println("Maximum Path Sum: " + maxSum(root));
    }
}
