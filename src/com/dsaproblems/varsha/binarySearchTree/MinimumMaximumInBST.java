package com.dsaproblems.varsha.binarySearchTree;

public class MinimumMaximumInBST {

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

    public static int getMinimum(Node root){
        if(root == null){
            return -1;
        }

        while(root.left != null){
            root = root.left;
        }

        return root.data;
    }

    public static int getMaximum(Node root){
        if(root == null){
            return -1;
        }

        while(root.right != null){
            root = root.right;
        }

        return root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(getMinimum(root));
        System.out.println(getMaximum(root));
    }
}
