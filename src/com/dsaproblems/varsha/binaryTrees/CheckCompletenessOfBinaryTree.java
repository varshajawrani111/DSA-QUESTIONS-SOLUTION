package com.dsaproblems.varsha.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfBinaryTree {

    static class  Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    public static boolean isComplete(Node root){
        if(root==null){
            return true;
        }

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        boolean foundNull = false;
        while(!queue.isEmpty()){

            Node curr = queue.poll();

            if(curr == null){
                foundNull = true;
            }
            else{
                if(foundNull){
                    return false;
                }
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {

        /*
                Example Tree

                    1
                   / \
                  2   3
                 / \  /
                4  5 6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        System.out.println("Is Complete Binary Tree? " +
                isComplete(root));
    }
}
