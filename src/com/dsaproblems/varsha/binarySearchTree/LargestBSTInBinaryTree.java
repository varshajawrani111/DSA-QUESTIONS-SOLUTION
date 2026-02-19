package com.dsaproblems.varsha.binarySearchTree;

public class LargestBSTInBinaryTree {

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

    static class Info{
        int min;
        int max;
        int maxSize;

        Info(int min, int max, int maxSize){
            this.min = min;
            this.max = max;
            this.maxSize = maxSize;
        }
    }


}
