package com.dsaproblems.varsha.binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorderTraversal {

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

    public static List<Integer> morrisPreorderTraversal(Node root){

        List<Integer> res = new ArrayList<>();

        Node curr = root;

        while(curr!=null){

            if(curr.left == null){
                res.add(curr.data);
                curr = curr.right;
            }
            else{
                //Find the Inorder Predecessor
                //rightmost node of the left subtree
                Node ip = curr.left;
                while(ip.right!=null&&ip.right!=curr){
                    ip = ip.right;
                }

                if(ip.right == null){
                    ip.right = curr; //creating the thread for backtracking towards the root
                    res.add(curr.data); //this is the root so we will print it
                    curr = curr.left;
                }
                else {
                    ip.right = null; //destroy the thread
                    curr = curr.right;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \
            4   5
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(morrisPreorderTraversal(root));
    }
}
