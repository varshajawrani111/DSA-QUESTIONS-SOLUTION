package com.dsaproblems.varsha.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewAndRightViewOfTree {

    static class  Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void leftView(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {

            //to keep number of nodes at each level
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if(i==0) //printing first node of evry level
                    System.out.print(node.data + " ");

                //adding its children to queue
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }
    }

    public static void rightView(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {

            //to keep number of nodes at each level
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if(i == size-1) //printing last node of every level
                    System.out.print(node.data + " ");

                //adding its children to queue
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(5);

        System.out.print("Left view: ");
        leftView(root);


        System.out.print("\nRight view: ");
        rightView(root);
    }
}
