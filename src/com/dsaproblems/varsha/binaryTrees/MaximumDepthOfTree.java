package com.dsaproblems.varsha.binaryTrees;


import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfTree {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    //Here we are considering the depth of tree as number of nodes from root to leaf node

    //Using recursion
    public static int maxDepthUsingRecursion(Node root) {

        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //Using BFS traversal
    public static int maxDepth(Node root) {
        if (root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(maxDepthUsingRecursion(root));
        System.out.println(maxDepth(root));


    }
}
