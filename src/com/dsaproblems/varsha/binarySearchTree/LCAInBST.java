package com.dsaproblems.varsha.binarySearchTree;

public class LCAInBST {
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

    public static Node lcaInBST(Node root, Node p, Node q){
        if(root == null){
            return null;
        }

        if(root.data > p.data && root.data > q.data){
            lcaInBST(root.left,p,q);
        }
        else if(root.data < p.data && root.data < q.data){
            lcaInBST(root.right,p,q);
        }

        // Split happens here OR one node equals root
        return root;
    }

    public static void main(String[] args) {

        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);
        root.right.right = new Node(6);

        Node p = root.left;
        Node q = root.right;

        System.out.println("LCA In BST: "+ lcaInBST(root,p,q).data);
    }
}
