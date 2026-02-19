package com.dsaproblems.varsha.binarySearchTree;

import java.util.Stack;

public class KthSmallestElementInBST {

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

    public static int kthSmallest(Node root,int k){
        if(root == null){
            return -1;
        }

        Stack<Node> stack = new Stack<>();

        while(true){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop(); //imp step
            k--;

            if(k == 0){
                return root.data;
            }

            root = root.right;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left.right = new Node(1);

        System.out.println(kthSmallest(root,3));
    }
}
