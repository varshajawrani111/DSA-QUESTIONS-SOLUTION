package com.dsaproblems.varsha.binaryTrees;

public class FlattenBinaryTreeIntoLinkedList {

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

    public static void flattenTree(Node root){
        Node current = root;

        while(current != null){

            if(current.left != null){

                Node pred = current.left;

                //finding the rightmost node of the left child
                while(pred.right != null){
                    pred = pred.right;
                }

                //assigning the rightmost node the right subtree
                pred.right = current.right;

                //moving the left subtree towards right
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }
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
        root.left = new Node(4);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);

        inOrderTraversal(root);

        flattenTree(root);

        System.out.println();

        inOrderTraversal(root);
    }
}
