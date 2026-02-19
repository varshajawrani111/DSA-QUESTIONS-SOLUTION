package com.dsaproblems.varsha.binaryTrees;

public class ConstructTreeFromPreorderPostorder {

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

    /*  🔴 A unique binary tree CANNOT be constructed from preorder + postorder alone
        ✅ UNLESS the tree is a FULL binary tree
    */
    static int preIndex = 0;

    public static Node buildTree(int[] preorder, int[] postorder){
        preIndex = 0;

        return constructTree(preorder,postorder,0,postorder.length-1);
    }

    public static Node constructTree(int[] preorder, int[] postorder, int postStart, int postEnd){

        //base case
        if(preIndex > preorder.length-1 || postStart > postEnd){
            return null;
        }

        //create the root from preorder
        Node root = new Node(preorder[preIndex++]);

        //if leaf node
        if(postStart == postEnd){
            return root;
        }

        //find the left child--next preorder value is left child
        int leftChild = preorder[preIndex];

        //find left child in postorder
        int index = postStart;
        while(postorder[index] != leftChild){ //instead of this hashmap can also be used like we did for inorder traversal
            index++;
        }

        //build left right subtree
        //poststart->index == left subtree
        //index+1->postend == right subtree
        root.left = constructTree(preorder,postorder,postStart,index);
        root.right = constructTree(preorder,postorder,index+1,postEnd-1);

        return root;

    }

    // -------- MAIN METHOD --------
    public static void main(String[] args) {

        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        Node root = buildTree(preorder, postorder);

        System.out.println("Tree constructed successfully (Full Binary Tree)");
    }


}
