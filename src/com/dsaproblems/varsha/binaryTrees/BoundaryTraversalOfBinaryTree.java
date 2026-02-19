package com.dsaproblems.varsha.binaryTrees;

import java.util.Stack;

public class BoundaryTraversalOfBinaryTree {

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

    public static void boundaryTraversal(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");

        //left boundary
        printLeftBoundary(root.left);

        //print leaf nodes
        printLeafNodes(root.left);
        printLeafNodes(root.right);

        //print right boundary
        printRightBoundary(root.right);
    }

    public static void printLeftBoundary(Node root){

        while(root!=null){
            if(!isLeaf(root)){ //excluding leaf nodes
                System.out.print(root.data+" "); //leaf boundary will be inorder i.e why not using extra data structure
            }

            //if left child is null prefer right child if it is not leaf
            if(root.left!=null){
                root=root.left;
            }
            else{
                root=root.right;
            }
        }
    }


    public static void printRightBoundary(Node root){
        Stack<Integer> stack = new Stack<Integer>();

        while(root!=null){
            if(!isLeaf(root)){ //excluding leaf nodes
                stack.push(root.data);
            }

            //if right child is null prefer the left child if it is not leaf
            if(root.right!=null){
                root=root.right;
            }
            else{
                root=root.left;
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }


    public static void printLeafNodes(Node root){
        if(root==null){
            return;
        }

        if(isLeaf(root)){
            System.out.print(root.data+" ");
        }

        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }


    public static boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {

        /*
                    20
                   /  \
                  8    22
                 / \     \
                4  12     25
                   / \
                  10 14
        */

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.right = new Node(25);

        System.out.print("Boundary Traversal: ");
        boundaryTraversal(root);
    }
}
