package com.dsaproblems.varsha.binaryTrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertBinaryTree {

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

    //inverting tree using recursion
    public static Node invertBinaryTreeUsingRecursion(Node root){

        if(root == null){
            return null;
        }

        //swaping left and right node
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        //recursively inverting the left and right subtree
        invertBinaryTreeUsingRecursion(root.left);
        invertBinaryTreeUsingRecursion(root.right);

        return root;
    }

    //inverting binary tree using BFS and Queue
    public static Node invertBinaryTreeUsingIteration(Node root){
        if(root == null){
            return null;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node curr = queue.poll();

            //swapping the left and right node of the current root
            Node temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
        }

        return root;
    }

    public static void inOrderTraversal(Node root){
        if(root == null){
            return;
        }


        inOrderTraversal(root.left);
        System.out.print(root.data + "->");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        invertBinaryTreeUsingIteration(root);
        System.out.println("Inorder Traversal: ");
        inOrderTraversal(root);

        System.out.println();

        invertBinaryTreeUsingRecursion(root);
        System.out.println("Inorder Traversal: ");
        inOrderTraversal(root);

    }
}
