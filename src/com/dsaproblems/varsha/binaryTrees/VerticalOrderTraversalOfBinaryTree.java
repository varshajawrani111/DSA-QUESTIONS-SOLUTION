package com.dsaproblems.varsha.binaryTrees;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {

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

    static class Tuple{
        Node node;
        int row;
        int col;

        public Tuple(Node node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public static List<List<Integer>> verticalOrderTraversal(Node root){
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            res.add(new ArrayList<>());
            return res;
        }

        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0)); //root will have row zero and column zero

        //Tree map will store(col, row->all values in a same row in sorted order)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();

            int row = tuple.row;
            int col = tuple.col;
            Node node = tuple.node;
            int data = node.data;

            //if column does not exist in map
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).add(data);

            if(node.left != null){
                queue.offer(new Tuple(node.left, row + 1, col - 1));
            }

            if(node.right != null){
                queue.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }

        // Iterate columns from leftmost to rightmost (TreeMap guarantees order)
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            // This list will store all node values for one vertical column
            List<Integer> colList = new ArrayList<>();

            // Iterate rows from top to bottom within the same column
            for (PriorityQueue<Integer> pq : rows.values()) {

                // Multiple nodes can exist at same (col, row)
                // PriorityQueue ensures values are taken in ascending order
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }

            // Add this column’s final ordered list to result
            res.add(colList);
        }

        return res;
    }

    public static void main(String[] args) {

        /*
                    3
                   / \
                  9   20
                     /  \
                    15   7
        */

        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(verticalOrderTraversal(root));
    }
}
