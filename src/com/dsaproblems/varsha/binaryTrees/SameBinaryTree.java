package com.dsaproblems.varsha.binaryTrees;

public class SameBinaryTree {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isSameTree(Node root1,Node root2){

        //both nodes are null
        if(root1 == null && root2 == null){
            return true;
        }

        //if one the node is null
        if(root1 == null || root2 == null){
            return false;
        }

        //if the values differ
        if(root1.data != root2.data){
            return false;
        }

        //recursively check for left and right
        return isSameTree(root1.left,root2.left) && isSameTree(root1.right,root2.right);
    }

    public static void main(String[] args) {

        /*
            Tree 1           Tree 2
               1                1
              / \              / \
             2   3            2   3
        */

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        System.out.println("Are trees identical? " +
                isSameTree(root1, root2));
    }
}
