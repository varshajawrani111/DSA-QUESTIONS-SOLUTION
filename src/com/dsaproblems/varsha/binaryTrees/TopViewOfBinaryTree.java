package com.dsaproblems.varsha.binaryTrees;

import java.util.*;

public class TopViewOfBinaryTree {

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

    static class Pair{
        Node node;
        int line;

        Pair(Node node,int line){
            this.node = node;
            this.line = line;
        }
    }

    public static List<Integer> topViewOfBinaryTree(Node root){

        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0)); //line will start with 0 as root

        Map<Integer,Integer> map = new TreeMap<>(); //we are suing treemap because we need to maintain he order wrt line

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int hd = pair.line;
            Node node = pair.node;

            //top view means the first node in the line that is why we will be putting the first node in line map
            map.putIfAbsent(hd,node.data); //store only first node at each line/hd

            if(node.left != null){
                queue.add(new Pair(node.left,hd-1)); //for left child the hd = line -1
            }
            if(node.right != null){
                queue.add(new Pair(node.right,hd+1)); //for right child hd = line + 1
            }
        }

        ans.addAll(map.values());

        return ans;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(topViewOfBinaryTree(root));

    }
}
