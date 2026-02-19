package com.dsaproblems.varsha.binarySearchTree;

import java.util.Stack;

public class KthLargestElementInBST {

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

    public static int KthLargestElement(Node root,int k){
        if(root == null){
            return -1;
        }

        Stack<Node> stack = new Stack<>();

        while(true){
            while(root != null){
                stack.push(root);
                root = root.right; //reversal of inorder
            }

            root = stack.pop();
            k--;

            if(k == 0){
                return root.data;
            }

            root = root.left;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left.right = new Node(1);

        System.out.println(KthLargestElement(root,3));
    }
}
