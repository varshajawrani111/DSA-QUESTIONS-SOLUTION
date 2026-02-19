package com.dsaproblems.varsha.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextBinaryPointers {

    static class  Node{
        int data;
        Node left;
        Node right;
        Node next;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
            this.next = null;
        }
    }

    //this will for only full binary tree
    public static void connect(Node root){
        if(root == null){
            return;
        }

        Node levelStart = root;

        while(levelStart.left != null){

            Node current = levelStart;


            while(current != null){

                //connect left to right
                current.left.next = current.right;

                //connect right->next.left
                if(current.next != null){

                    current.right.next = current.next.left;

                }

                current = current.next;
            }

            levelStart = levelStart.left;
        }
    }

    //this will work for any binary tree
    public static void connectAnyTree(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            prev.next = null; // last node
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        connect(root);
        connectAnyTree(root);
    }

}
