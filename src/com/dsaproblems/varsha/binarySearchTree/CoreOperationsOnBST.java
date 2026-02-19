package com.dsaproblems.varsha.binarySearchTree;

public class CoreOperationsOnBST {

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

    static Node root;

    public static Node insert(Node root,int key){

        if(root == null){
            return  new Node(key);
        }

        if(key < root.data){
            root.left = insert(root.left,key);
        }
        else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    public static Node delete(Node root,int key){
        if(root == null){
            return null;
        }

        //Find the node to delete
        if(key < root.data){
            root.left = delete(root.left,key);
        }
        else if(key > root.data){
            root.right = delete(root.right,key);
        }

        else {
            //Found the node
            //Check if the node has 0 or 1 child
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            //Node has 2 children
            Node successor = findMin(root.right);

            root.data = successor.data; //replace the node value with successor value

            root.right = delete(root.right,successor.data); //delete the successor node
        }

        return root;
    }

    public static Node findMin(Node node){

        while(node.left != null){
            node = node.left;
        }

        return node;
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void main(String[] args) {

        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 5);
        root = insert(root, 6);
        root = insert(root, 7);
        root = insert(root, 8);

        inOrder(root);
        System.out.println();

        root = delete(root, 10);  // ✅ must assign back
        inOrder(root);
        System.out.println();

        root = delete(root, 7);
        inOrder(root);

    }
}
