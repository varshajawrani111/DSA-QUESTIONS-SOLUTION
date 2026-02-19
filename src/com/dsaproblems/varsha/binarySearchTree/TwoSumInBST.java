package com.dsaproblems.varsha.binarySearchTree;

import java.util.Stack;

public class TwoSumInBST {

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

    //this class is similar to the iterator class of java
    static class BSTIterator{
        Stack<Node> stack = new Stack<>();
        boolean reversed;  //next->reverse false //before->reverse true

        public BSTIterator(Node root, boolean reverse){
            this.reversed = reverse;
            pushAll(root, reverse);
        }

        private void pushAll(Node root, boolean reverse){

            while (root != null){
                stack.push(root);

                if(reverse){
                    root = root.right; //next greater element if left node is processed

                }else {
                    root = root.left; //next smaller element if right node is processed-->same as next() function in iterator
                }
            }
        }

        public int next(){
            Node node = stack.pop();
            int value = node.data;

            if(reversed){
                pushAll(node.left, reversed);
            }
            else {
                pushAll(node.right, reversed);
            }

            return value;
        }
    }

    public static boolean findTwoSum(Node root, int target){
        if(root == null){
            return false;
        }

        //this will initialize two different stack not one stack
        BSTIterator left = new BSTIterator(root, false); //to put all the smaller elements from left subtree
        BSTIterator right = new BSTIterator(root, true); //to put all the greater elements from right subtree

        int i = left.next();
        int j = right.next();

        while(i < j){

            int sum = i + j;
            if(sum == target){
                return true;
            }
            else if(sum > target){
                j = right.next();
            }
            else{
                i = left.next();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);

        int target = 9;

        System.out.println(findTwoSum(root, target));
    }
}
