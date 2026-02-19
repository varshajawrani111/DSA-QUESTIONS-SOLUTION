package com.dsaproblems.varsha.binaryTrees;

public class RootToLeafPathSumI {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean hasPathSum(Node root, int targetSum){
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            return root.data  == targetSum;
        }

        int remainingSum = targetSum - root.data;

        return hasPathSum(root.left,remainingSum) || hasPathSum(root.right,remainingSum);
    }

    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);

        System.out.println(hasPathSum(root,22));
    }
}
