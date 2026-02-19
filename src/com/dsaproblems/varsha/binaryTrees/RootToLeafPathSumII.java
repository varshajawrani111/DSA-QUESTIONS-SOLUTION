package com.dsaproblems.varsha.binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPathSumII {

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

    public static List<List<Integer>> pathSum(Node root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, res, path, targetSum);
        return res;
    }

    public static void dfs(Node root, List<List<Integer>> res, List<Integer> path, int targetSum){
        if(root == null){
            return;
        }

        //add current node to path
        path.add(root.data);
        targetSum -= root.data;

        //check leaf
        if(root.left == null && root.right == null && targetSum == 0){
            res.add(new ArrayList<>(path));
        }

        //recurse
        dfs(root.left, res, path, targetSum);
        dfs(root.right, res, path, targetSum);

        //backtrack
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);

        System.out.println(pathSum(root,22));
    }
}
