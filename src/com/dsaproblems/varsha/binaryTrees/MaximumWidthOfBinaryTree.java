package com.dsaproblems.varsha.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

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

    static class Pair{
        Node node;
        int index;
        public Pair(Node node, int index){
            this.node = node;
            this.index = index;
        }
    }

    public static int maxWidthOfBinaryTree(Node root){
        if(root == null){
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0)); //storing root with index zero

        int maxWidth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            int firstIndex = queue.peek().index; //getting hte first index of the level from first element in queue
            int lastIndex = firstIndex; //initialization

            for(int i = 0; i < size; i++){

                Pair pair = queue.poll();
                Node node = pair.node;
                int index = pair.index;

                lastIndex = index;

                // normalize index to avoid overflow
                int normalized = index - firstIndex;

                if(node.left != null){
                    queue.add(new Pair(node.left, 2*normalized + 1));
                }

                if(node.right != null){
                    queue.add(new Pair(node.right, 2*normalized + 2));
                }
            }

            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1); //getting max width after every level
        }

        return maxWidth;
    }

    public static void main(String[] args) {

        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        System.out.println("Maximum Width of Binary Tree: "+ maxWidthOfBinaryTree(root));
    }
}
