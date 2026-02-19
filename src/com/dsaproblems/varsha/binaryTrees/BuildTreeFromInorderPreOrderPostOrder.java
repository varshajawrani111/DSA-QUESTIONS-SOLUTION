package com.dsaproblems.varsha.binaryTrees;

import java.util.HashMap;

public class BuildTreeFromInorderPreOrderPostOrder {

    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    //building tree from preorder and inorder
    int preIndex = 0; //root will at first element
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); //to store the value in order and its index


    public Node buildTree(int[] inorder, int[] preorder){

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return construct(preorder, 0, inorder.length-1);
    }

    public Node construct(int[] preorder, int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }

        int val = preorder[preIndex++];
        Node root = new Node(val); //adding first of element of preorder as root node/parent

        int mid = map.get(val);

        root.left = construct(preorder,inStart,mid-1);
        root.right = construct(preorder,mid+1,inEnd);

        return  root;
    }



    //building tree from postorder and inorder
    int postIndex; //root will at first element

    public Node buildTreeFromPostOrder(int[] inorder, int[] postorder){
        postIndex = postorder.length-1;

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return constructTree(postorder, 0, inorder.length-1);
    }

    public Node constructTree(int[] postorder, int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }

        int val = postorder[postIndex--];
        Node root = new Node(val); //adding first of element of preorder as root node/parent

        int mid = map.get(val);

        //build right tree first
        root.right = constructTree(postorder,mid+1,inEnd);
        root.left = constructTree(postorder,inStart,mid-1);

        return  root;
    }


    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        Node root =  new BuildTreeFromInorderPreOrderPostOrder().buildTree(inorder,preorder);
        System.out.println(root.val);

        Node root1 = new BuildTreeFromInorderPreOrderPostOrder().buildTreeFromPostOrder(inorder,postorder);
        System.out.println(root1.val);
    }
}
