package com.dsaproblems.varsha.binarySearchTree;

public class FloorAndCeilInBST {

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

    public static Node floorInBST(Node root,int data){

        if(root==null){
            return null;
        }

        Node floor = null;

        while(root!=null){

            if(root.data==data){
                floor = root;
                break;
            }
            else if(root.data < data){
                floor = root; //possible floor
                root = root.right; //smaller than can be there
            }
            else{
                root = root.left;
            }
        }

        return floor;
    }

    public static Node ceilInBST(Node root,int data){
        if(root==null){
            return null;
        }

        Node ceil = null;

        while(root!=null){

            if(root.data==data){
                ceil = root;
                break;
            }
            else if(root.data >= data){
                ceil = root; //possible ceil
                root = root.left; //smaller this can be there
            }
            else{
                root = root.right;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(80);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(90);

        Node floor = floorInBST(root,7);
        Node ceil = ceilInBST(root,80);

        System.out.println(floor == null? -1 : floor.data);
        System.out.println(ceil == null? -1 : ceil.data);
    }
}
