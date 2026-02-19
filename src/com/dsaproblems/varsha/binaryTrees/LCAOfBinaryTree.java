package com.dsaproblems.varsha.binaryTrees;

public class LCAOfBinaryTree {

    static class  Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node lcaOfBinaryTree(Node root, Node p, Node q){

        //if root is null or equal to one of the node return that value
        if(root == null || root == p || root == q){
            return root;
        }

        Node left = lcaOfBinaryTree(root.left, p, q);
        Node right = lcaOfBinaryTree(root.right, p, q);

        //if both are not null return the root
        if(left != null && right != null){
            return root;
        }

        //if one them is null return non-null node
        return left != null ? left : right;
    }

    public static void main(String[] args) {

        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        Node p = root.left;
        Node q = root.right;

        Node lca = lcaOfBinaryTree(root, p, q);
        System.out.println("LCA of Binary Tree: "+ lca.data);
    }


}
