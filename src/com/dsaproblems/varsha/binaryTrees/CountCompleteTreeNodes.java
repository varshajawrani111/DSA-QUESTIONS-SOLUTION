package com.dsaproblems.varsha.binaryTrees;

public class CountCompleteTreeNodes {

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

    public static int countNodes(Node root){

        if(root == null){
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        //this is the property of complete binary tree
        //if height of left tree and right subtree are equal then it will have 2^h - 1 nodes
        if(leftHeight == rightHeight){
            return (1 << leftHeight) - 1; //2^h -1
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // -------- LEFT HEIGHT --------
    private static int getLeftHeight(Node node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    // -------- RIGHT HEIGHT --------
    private static int getRightHeight(Node node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    public static void main(String[] args) {

        /*
                Complete Binary Tree

                        1
                       / \
                      2   3
                     / \  /
                    4  5 6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        System.out.println("Total nodes: " + countNodes(root));
    }
}
