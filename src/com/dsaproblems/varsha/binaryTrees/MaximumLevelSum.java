package com.dsaproblems.varsha.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSum {
    static class  Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static int maxLevelSum(Node root){
        if(root == null){
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);


        int level = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;

        while (!queue.isEmpty()){

            int size = queue.size();
            int levelSum = 0;
            level++;

            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                levelSum += node.val;

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }

            if(levelSum > maxSum){
                maxSum = levelSum;
                maxLevel = level;
            }
        }

        return maxLevel;
    }

    public static void main(String[] args) {

        /*
                    1
                   / \
                  7   0
                 / \
                7  -8
        */

        Node root = new Node(1);
        root.left = new Node(7);
        root.right = new Node(0);
        root.left.left = new Node(7);
        root.left.right = new Node(-8);

        System.out.println("Level with maximum sum: " + maxLevelSum(root));
    }
}
