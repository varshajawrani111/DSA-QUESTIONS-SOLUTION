package com.dsaproblems.varsha.binaryTrees;

public class DiameterOfTree {

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

    //here diameter is mentioned in terms of number of edges
    static int diameter = 0;

    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight); //updates the diameter at every level
        //diameter = Math.max(diameter, leftHeight + rightHeight+1); //to get answer in number of nodes

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        height(root);

        System.out.println(diameter);
    }
}
