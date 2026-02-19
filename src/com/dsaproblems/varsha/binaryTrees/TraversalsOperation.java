package com.dsaproblems.varsha.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class TraversalsOperation {

    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void inorderTraversal(Node root){
        if(root == null){
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val + "->");
        inorderTraversal(root.right);
    }

    public static void preorderTraversal(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.val + "->");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void postorderTraversal(Node root){
        if(root == null){
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val + "->");
    }

    public static void levelOrderTraversal(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.val + "->");

            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \
            4   5
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print("Inorder Traversal: ");
        inorderTraversal(root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        preorderTraversal(root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        postorderTraversal(root);
        System.out.println();

        System.out.print("Level Order Traversal: ");
        levelOrderTraversal(root);
    }
}
