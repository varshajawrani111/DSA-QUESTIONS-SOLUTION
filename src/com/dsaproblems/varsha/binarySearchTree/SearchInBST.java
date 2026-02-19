package com.dsaproblems.varsha.binarySearchTree;

public class SearchInBST {

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

    //Recursive Approach
    public static Node searchBST(Node root,int key){
        if(root==null || root.data==key){
            return root;
        }

        if(key<root.data){
            return searchBST(root.left,key);
        }

        return searchBST(root.right,key);
    }

    //Iterative approach - preferable for interview
    public static Node searchBSTIterative(Node root,int key){

        while(root!=null){
            if(root.data==key){
                return root;
            }
            else if(key<root.data){
                root=root.left;
            }
            else{
                root=root.right;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(searchBST(root,3).data);
        System.out.println(searchBSTIterative(root,41));
    }
}
