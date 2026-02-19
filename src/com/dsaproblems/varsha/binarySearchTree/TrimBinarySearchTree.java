package com.dsaproblems.varsha.binarySearchTree;

public class TrimBinarySearchTree {

    static class  Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static Node trim(Node root, int low, int high){
        if(root == null){
            return null;
        }

        /*
        * If root.val < low
            Entire left subtree is invalid
            Valid nodes (if any) can only be in right subtree
            ➡ Discard root & left subtree
            ➡ Return trim(root.right)
        */
        if(root.val < low){
            return trim(root.right, low, high);
        }

        /*
        * If root.val > high
        Entire right subtree is invalid
        Valid nodes (if any) can only be in left subtree
        ➡ Discard root & right subtree
        ➡ Return trim(root.left)*/
        if(root.val > high){
            return trim(root.left, low, high);
        }

        /*
        * If low ≤ root.val ≤ high
            Root is valid
            Recursively trim both children*/
        root.left = trim(root.left, low, high);
        root.right = trim(root.right, low, high);

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(0);
        root.right = new Node(2);

        int low = 1;
        int high = 2;

        root =  trim(root, low, high);
        System.out.println(root.val);
    }
}
