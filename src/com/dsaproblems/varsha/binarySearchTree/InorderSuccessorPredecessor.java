package com.dsaproblems.varsha.binarySearchTree;

public class InorderSuccessorPredecessor {

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

    public static Node inorderSuccessor(Node root,int data){

        if(root==null){
            return null;
        }

        Node successor = null;

        while(root!=null){

            if(root.data > data){
                successor = root; //this is a possible successor
                root = root.left;
            }
            else {
                root = root.right;
            }
        }

        return successor;
    }

    public static Node inorderPredecessor(Node root,int data){

        if(root==null){
            return null;
        }

        Node predecessor = null;

        while(root!=null){

            if(root.data < data){
                predecessor = root; //possible predecessor
                root = root.right;
            }
            else {
                root = root.left;
            }
        }

        return predecessor;
    }

    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left.left = new Node(1); // ✅ fixed BST

        Node succ = inorderSuccessor(root, 5);
        Node pred = inorderPredecessor(root, 6);

        System.out.println(succ != null ? succ.data : "null");
        System.out.println(pred != null ? pred.data : "null");
    }
}
