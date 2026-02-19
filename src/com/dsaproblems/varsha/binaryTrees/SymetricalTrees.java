package com.dsaproblems.varsha.binaryTrees;

public class SymetricalTrees {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public static boolean isSymmetrical(Node root){
            if(root == null){
                return true;
            }

            return isMirror(root.left, root.right);
        }

        public static boolean isMirror(Node left,Node right){

            //if both left and reight are null
            if(left == null && right == null){
                return true;
            }

            //if one of them is null
            if(left == null || right == null){
                return false;
            }

            //if values of both differs
            if(left.data != right.data){
                return false;
            }

            //check the mirror of left with right
            return isMirror(left.right, right.left) && isMirror(left.left, right.right);
        }

        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(2);
            root.left.left = new Node(3);
            root.left.right = new Node(4);
            root.right.left = new Node(4);
            root.right.right = new Node(3);

            System.out.println(isSymmetrical(root));
        }
    }
}
