package com.dsaproblems.varsha.binaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

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

    static Map<String,Integer> map = new HashMap<>(); //to store the structure of every subtree
    static List<Node> list = new ArrayList<>();

    public static List<Node>  findDuplicateSubtrees(Node root){
            serialize(root);
            return list;
    }

    public static String serialize(Node root){
        if(root == null){
            return "#"; //# is used a null marker
        }

        //Doing DFS-->post order
        String left = serialize(root.left);
        String right = serialize(root.right);

        String subtree = left + "," + right + "," + root.data; //in postorder format

        //storing structure in map
        map.put(subtree,map.getOrDefault(subtree,0)+1);

        //checking if frequency is 2
        if(map.get(subtree) == 2){
            list.add(root); //adding the root of the tree
        }

        return subtree;
    }

    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 /   / \
                4   2   4
                   /
                  4
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.right = new Node(4);
        root.right.left.left = new Node(4);

        List<Node> duplicates = findDuplicateSubtrees(root);

        System.out.println("Duplicate subtree roots:");
        for (Node node : duplicates) {
            System.out.println(node.data);
        }
    }
}
