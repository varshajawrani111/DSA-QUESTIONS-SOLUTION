package com.dsaproblems.varsha.binarySearchTree;

public class ClosestValueInBST {

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

    public static int findClosest(Node root, float target){

        int closestVal = root.val;

        while (root != null){

            if(Math.abs(root.val - target) < Math.abs(closestVal - target)){
                closestVal = root.val;
            }

            if(root.val < target){
                root = root.right;
            }
            else{
                root = root.left;
            }
        }

        return closestVal;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);

        float target = 3.7F;
        int closestVal = findClosest(root, target);
        System.out.println(closestVal);
    }
}
