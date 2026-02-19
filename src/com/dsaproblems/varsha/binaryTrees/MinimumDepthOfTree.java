package com.dsaproblems.varsha.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfTree {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int minDepth(Node root){
        if(root == null){
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int depth = 1; //as root node is counted
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }

            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(MinimumDepthOfTree.minDepth(root));
    }
}
