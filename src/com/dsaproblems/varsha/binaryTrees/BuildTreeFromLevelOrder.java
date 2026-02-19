package com.dsaproblems.varsha.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTreeFromLevelOrder {

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

    Node root;

    public Node buildTreeFromLevelOrder(Integer[] nums){

        if(nums[0] == null|| nums.length == 0){
            return null;
        }

        root = new Node(nums[0]);

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int idx = 1;

        while(!q.isEmpty() && idx<nums.length){

            Node curr = q.poll(); //popping the node which requires the children

            if(nums[idx] != null){
                curr.left = new Node(nums[idx]);
                q.add(curr.left); //pushing the left children in the queue which will require the children
            }
            idx++;

            if(idx<nums.length && nums[idx] != null){
                curr.right = new Node(nums[idx]);
                q.add(curr.right); //pushing the right children in the queue which will require the children
            }
            idx++;
        }

        return root;
    }

    public static void main(String[] args) {
        BuildTreeFromLevelOrder tree = new BuildTreeFromLevelOrder();

        Integer[] nums = {1,2,3,4,5,6,7,8,9,10};

        Node root = tree.buildTreeFromLevelOrder(nums);
        System.out.println(root.val);
    }
}
