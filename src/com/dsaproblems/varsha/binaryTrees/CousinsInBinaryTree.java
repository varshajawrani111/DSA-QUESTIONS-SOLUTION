package com.dsaproblems.varsha.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {

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

    public static boolean areCousins(Node root, int p, int q){
        if(root == null){
            return false;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean foundP = false;
            boolean foundQ = false;

            for(int i = 0; i < size; i++){
                Node node = queue.poll();

                if(node.left != null && node.right != null) {
                    if (node.left.data == p && node.right.data == q ||
                            node.left.data == q && node.right.data == p) {
                        return false; //there are siblings as current popped out node it the parent of both
                    }
                }

                //if p is found
                if(node.data == p){
                    foundP = true;
                }
                //if q is found
                if(node.data == q){
                    foundQ = true;
                }

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }

            if(foundP && foundQ){
                return true;
            }
            if(foundP || foundQ){
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        /*
                    1
                   / \
                  2   3
                   \   \
                    4   5
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(5);

        System.out.println(areCousins(root, 4, 5)); // true
    }
}
