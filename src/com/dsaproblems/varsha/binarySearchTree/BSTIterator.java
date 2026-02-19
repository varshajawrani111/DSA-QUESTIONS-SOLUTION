package com.dsaproblems.varsha.binarySearchTree;

import java.util.Stack;

public class BSTIterator {

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

    static Stack<Node> stack = new Stack<Node>(); //to store the elements of BST in sorted order

    public static void BSTIterator(Node root){
        pushLeft(root);
    }

    //Push all left nodes
    public static void pushLeft(Node node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

    public static boolean hasNext(){
        return !stack.isEmpty();
    }

    //Returns next small element
    public static int next() {

        Node node = stack.pop();
        int result = node.data;

        if(node.right != null){
            pushLeft(node.right); //to process the right subtree of popped out node
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(15);
        root.right.left = new Node(9);
        root.right.right = new Node(20);

        BSTIterator(root);
        System.out.println(next());
        System.out.println(next());

        System.out.println(hasNext());
        System.out.println(next());

        System.out.println(hasNext());
        System.out.println(next());

        System.out.println(hasNext());
        System.out.println(next());

        System.out.println(hasNext());
    }


}
